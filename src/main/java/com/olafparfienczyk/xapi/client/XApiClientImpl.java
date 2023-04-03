package com.olafparfienczyk.xapi.client;

import com.olafparfienczyk.xapi.client.codec.Codec;
import com.olafparfienczyk.xapi.client.connection.XApiConnection;
import com.olafparfienczyk.xapi.client.connection.XApiConnectionFactory;
import com.olafparfienczyk.xapi.client.model.SymbolRecord;
import com.olafparfienczyk.xapi.client.model.command.Command;
import com.olafparfienczyk.xapi.client.model.command.arguments.LoginArguments;
import com.olafparfienczyk.xapi.client.model.response.GetAllSymbolsResponse;
import com.olafparfienczyk.xapi.client.model.response.LoginResponse;
import com.olafparfienczyk.xapi.client.model.response.Response;

import java.io.IOException;
import java.util.List;

public class XApiClientImpl implements XApiClient {

    private final XApiConnectionFactory connectionFactory;
    private final Codec codec;
    private final XApiConfig config;

    private XApiConnection connection;
    private XApiCredentials credentials;
    private boolean closed;

    private String streamSessionId;

    public XApiClientImpl(XApiConnectionFactory connectionFactory, Codec codec, XApiConfig config) {
        this.connectionFactory = connectionFactory;
        this.codec = codec;
        this.config = config;
    }

    @Override
    public void setCredentials(XApiCredentials credentials) {
        this.credentials = credentials;
    }

    @Override
    public void ping() throws XApiException {
        ensureConnectivity();
        exchange(
                new Command()
                        .setCommand("ping"),
                Response.class);
    }

    @Override
    public List<SymbolRecord> getAllSymbols() throws XApiException {
        ensureConnectivity();
        return exchange(
                new Command()
                        .setCommand("getAllSymbols"),
                GetAllSymbolsResponse.class)
                .getReturnData();
    }

    @Override
    public XApiStream openStream() throws XApiException {
        return new XApiStreamImpl(
                connectionFactory,
                config.getStreamingHost(),
                config.getStreamingPort(),
                streamSessionId,
                codec);
    }

    @Override
    public void close() {
        if (connection != null) {
            connection.close();
        }
        closed = true;
    }

    private void ensureConnectivity() throws XApiException {
        if (closed) {
            throw new XApiException("Client was closed");
        }
        if (connection == null || connection.isClosed()) {
            try {
                connection = connectionFactory.newConnection(config.getHost(), config.getPort());
            } catch (IOException e) {
                throw new XApiException("Failed to open connection", e);
            }
            authenticate();
        }
    }

    private void authenticate() throws XApiException {
        if (credentials != null) {
            LoginResponse loginResponse =
                    exchange(new Command()
                                    .setCommand("login")
                                    .setArguments(
                                            new LoginArguments()
                                                    .setUserId(credentials.getUserId())
                                                    .setPassword(credentials.getPassword())
                                                    .setAppName(credentials.getAppName())),
                            LoginResponse.class);
            streamSessionId = loginResponse.getStreamSessionId();
        }
    }

    private <T extends Response> T exchange(Command command, Class<T> responseType) throws XApiException {
        try {
            connection.send(codec.encode(command));
            T response = codec.decode(connection.receive(), responseType);
            if (!response.isStatus()) {
                throw new XApiException("Command failed: "
                        + response.getErrorDescr()
                        + " (" + response.getErrorCode() + ")");
            }
            return response;
        } catch (IOException e) {
            throw new XApiException("Exchange failed", e);
        }
    }
}
