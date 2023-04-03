package com.olafparfienczyk.xapi.client.connection;

import java.io.IOException;

public interface XApiConnectionFactory {

    XApiConnection newConnection(String host, int port) throws IOException;

}