package com.olafparfienczyk.xapi.client.connection;

import java.io.IOException;

public interface XApiConnection extends AutoCloseable {

    void send(String data) throws IOException;

    String receive() throws IOException;

    void close();

    boolean isClosed();

}