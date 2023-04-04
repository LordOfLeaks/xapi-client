package com.olafparfienczyk.xapi.client.connection;

import java.io.IOException;

/**
 * Low-level representation of connection to xAPI server.
 */
public interface XApiConnection extends AutoCloseable {

    /**
     * Sends given data to xAPI server without waiting for response.
     * If writing fails this connection will be closed.
     *
     * @param data data to be sent
     * @throws IOException if writing fails for any reason
     */
    void send(String data) throws IOException;

    /**
     * Receives next message from xAPI server, blocking if necessary.
     * If reading fails this connection will be closed.
     *
     * @return data received from xAPI server
     * @throws IOException if reading fails for any reason
     */
    String receive() throws IOException;

    /**
     * Closes any underlying resources, interrupts ongoing reads and writes.
     */
    void close();

    /**
     * Checks if this connection is closed.
     *
     * @return {@code true} if this connection has been closed
     */
    boolean isClosed();

}