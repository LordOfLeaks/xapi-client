package com.olafparfienczyk.xapi.client;

import com.olafparfienczyk.xapi.client.codec.Codec;
import com.olafparfienczyk.xapi.client.codec.CodecException;
import com.olafparfienczyk.xapi.client.connection.XApiConnection;
import com.olafparfienczyk.xapi.client.connection.XApiConnectionFactory;
import com.olafparfienczyk.xapi.client.model.StreamingBalanceRecord;
import com.olafparfienczyk.xapi.client.model.StreamingCandleRecord;
import com.olafparfienczyk.xapi.client.model.command.streaming.GetCandlesStreamingCommand;
import com.olafparfienczyk.xapi.client.model.command.streaming.StreamingCommand;
import com.olafparfienczyk.xapi.client.model.message.GenericMessage;
import com.olafparfienczyk.xapi.client.model.message.GetBalanceMessage;
import com.olafparfienczyk.xapi.client.model.message.GetCandlesMessage;
import com.olafparfienczyk.xapi.client.model.message.Message;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class XApiStreamImpl implements XApiStream {

    private class MessageHandler<T> {

        final Class<? extends T> messageType;
        final Collection<StreamListener<T>> listeners = new ConcurrentLinkedQueue<>();

        MessageHandler(Class<? extends T> messageType) {
            this.messageType = messageType;
        }

        void handle(String encodedMessage) throws XApiException {
            T msg;
            try {
                msg = codec.decode(encodedMessage, messageType);
            } catch (CodecException e) {
                throw new XApiException("Failed to decode message", e);
            }
            XApiException firstException = null;
            for (StreamListener<T> listener : listeners) {
                try {
                    listener.onMessage(msg);
                } catch (Exception e) {
                    if (firstException == null) {
                        firstException = new XApiException("Exception in stream listener", e);
                    } else {
                        firstException.addSuppressed(e);
                    }
                }
            }
            if (firstException != null) {
                throw firstException;
            }
        }

    }

    private final Lock writeLock = new ReentrantLock();
    private final AtomicBoolean listening = new AtomicBoolean(false);
    private final Map<String, MessageHandler<?>> messageHandlersByCommands = new ConcurrentHashMap<>();
    private final XApiConnection connection;
    private final String streamSessionId;
    private final Codec codec;

    private volatile boolean closed = false;

    public XApiStreamImpl(XApiConnectionFactory connectionFactory,
                          String host,
                          int port,
                          String streamSessionId,
                          Codec codec) throws XApiException {
        if (streamSessionId == null) {
            throw new XApiException("streamSessionId not provided. Is the main connection authenticated?");
        }
        try {
            this.connection = connectionFactory.newConnection(host, port);
        } catch (IOException e) {
            throw new XApiException("Failed to open streaming connection", e);
        }

        this.streamSessionId = streamSessionId;
        this.codec = codec;
    }

    @Override
    public void getBalance() throws XApiException {
        send(
                new StreamingCommand()
                        .setCommand("getBalance")
                        .setStreamSessionId(streamSessionId));
    }

    @Override
    public void stopBalance() throws XApiException {
        send(
                new StreamingCommand()
                        .setCommand("stopBalance"));
    }

    @Override
    public void getCandles(String symbol) throws XApiException {
        send(
                new GetCandlesStreamingCommand()
                        .setSymbol(symbol)
                        .setCommand("getCandles")
                        .setStreamSessionId(streamSessionId));
    }

    @Override
    public void stopCandles() throws XApiException {
        send(
                new StreamingCommand()
                        .setCommand("stopCandles"));
    }

    @Override
    public void addGetBalanceListener(StreamListener<Message<StreamingBalanceRecord>> listener) {
        addListener("balance", listener, GetBalanceMessage.class);
    }

    @Override
    public void addGetCandlesListener(StreamListener<Message<StreamingCandleRecord>> listener) {
        addListener("candle", listener, GetCandlesMessage.class);
    }

    @Override
    public void listen() throws XApiException {
        if (!listening.compareAndSet(false, true)) {
            throw new XApiException("Already listening");
        }
        try {
            while (!isClosed()) {
                String command;
                String encodedMessage;
                try {
                    encodedMessage = connection.receive();
                    command = codec.decode(
                                    encodedMessage,
                                    GenericMessage.class)
                            .getCommand();
                    receiveMessage(command, encodedMessage);
                } catch (IOException e) {
                    if (closed) {
                        //graceful close, ignore IO errors
                        break;
                    }
                    throw new XApiException("Failed to receive message", e);
                }
            }
        } finally {
            close();
            listening.set(false);
        }
    }

    private void receiveMessage(String command, String encodedMessage) throws XApiException {
        MessageHandler<?> messageHandler = messageHandlersByCommands.get(command);
        if (messageHandler == null) {
            throw new XApiException("Received message '" + command + "' but no listener was found. " +
                    "Please make sure listener is added before the start command is sent.");
        }
        messageHandler.handle(encodedMessage);
    }

    @Override
    public void close() {
        closed = true;
        if (!listening.get()) {
            connection.close();
        }
    }

    private void send(StreamingCommand command) throws XApiException {
        writeLock.lock();
        try {
            connection.send(codec.encode(command));
        } catch (IOException e) {
            close();
            throw new XApiException("Failed to send command", e);
        } finally {
            writeLock.unlock();
        }
    }

    @SuppressWarnings("unchecked")
    private <T> void addListener(String command, StreamListener<T> listener, Class<? extends T> messageType) {
        MessageHandler<T> handler = (MessageHandler<T>) messageHandlersByCommands
                .computeIfAbsent(command, key -> new MessageHandler<>(messageType));
        handler.listeners.add(listener);
    }

    private boolean isClosed() {
        return closed || connection.isClosed();
    }
}