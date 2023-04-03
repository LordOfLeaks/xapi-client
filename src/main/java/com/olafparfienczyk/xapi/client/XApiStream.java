package com.olafparfienczyk.xapi.client;

import com.olafparfienczyk.xapi.client.model.StreamingBalanceRecord;
import com.olafparfienczyk.xapi.client.model.StreamingCandleRecord;
import com.olafparfienczyk.xapi.client.model.message.Message;

import java.io.Closeable;

/**
 * A streaming session that implements streaming commands, embodying publisher-subscriber pattern.
 * All the operations are atomic, meaning that they can be safely used across different threads.
 * <p/>
 * The stream should be closed after it's no longer needed to free any underlying resources.
 * Important thing to note is that <b>the stream should be closed before the parent {@link XApiClient}</b>.
 * Invalidating the session (i.e. by timing out or calling {@link XApiClient#close()} on the parent) should
 * force the server to close the streaming connection, but it will be outside of client's control.
 * Therefore, closing the stream manually is <b>strongly recommended</b>.
 *
 * @see <a href="http://developers.xstore.pro/documentation/#available-streaming-commands">xAPI Protocol Documentation for streaming commands</a>
 * @see XApiClient#openStream()
 */
public interface XApiStream extends Closeable {

    /**
     * Requests to start receiving <b>balance</b> streaming data.
     *
     * @throws XApiException raised when the command fails to be sent.
     * @see <a href="http://developers.xstore.pro/documentation/#streamgetBalance">xAPI Protocol Documentation for streaming getBalance</a>
     * @see #stopBalance()
     */
    void getBalance() throws XApiException;

    /**
     * Requests to stop receiving {@code balance} streaming data.
     *
     * @throws XApiException raised when the command fails to be sent.
     * @see <a href="http://developers.xstore.pro/documentation/#streamgetBalance">xAPI Protocol Documentation for streaming getBalance</a>
     * @see #getBalance()
     */
    void stopBalance() throws XApiException;

    /**
     * Requests to start receiving {@code candle} streaming data.
     *
     * @param symbol symbol to subscribe to.
     * @throws XApiException raised when the command fails to be sent.
     * @see <a href="http://developers.xstore.pro/documentation/#streamgetCandles">xAPI Protocol Documentation for streaming getCandles</a>
     * @see #stopCandles()
     */
    void getCandles(String symbol) throws XApiException;

    /**
     * Requests to stop receiving {@code candle} streaming data.
     *
     * @throws XApiException raised when the command fails to be sent.
     * @see <a href="http://developers.xstore.pro/documentation/#streamgetBalance">xAPI Protocol Documentation for streaming getCandles</a>
     * @see #getCandles(String)
     */
    void stopCandles() throws XApiException;

    /**
     * Adds a listener for <b>balance</b> streaming data.
     *
     * @param listener Listener
     */
    void addGetBalanceListener(StreamListener<Message<StreamingBalanceRecord>> listener);

    /**
     * Adds a listener for <b>candle</b> streaming data.
     *
     * @param listener Listener
     */
    void addGetCandlesListener(StreamListener<Message<StreamingCandleRecord>> listener);

    /**
     * Starts listening for incoming messages on the current thread.
     * Once message is received, it will call the associated listeners on the current thread.
     * The call order of which is <b>not guaranteed</b>.
     * <p/>
     * <b>Note:</b> This method will not throw if the stream was closed using the {@link #close()} method.
     * Such behavior may be used to implement a reconnect mechanism.
     *
     * @throws XApiException When listening couldn't be started or was interrupted unexpectedly
     */
    void listen() throws XApiException;

    /**
     * Gracefully closes the stream freeing any underlying resources.
     */
    void close();

}