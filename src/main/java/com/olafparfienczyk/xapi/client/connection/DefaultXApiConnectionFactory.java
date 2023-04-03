package com.olafparfienczyk.xapi.client.connection;

import java.io.IOException;

public class DefaultXApiConnectionFactory implements XApiConnectionFactory {

    @Override
    public XApiConnection newConnection(String host, int port) throws IOException {
        return new SSLXApiConnection(host, port);
    }
}