package com.olafparfienczyk.xapi.client.connection;

import java.io.IOException;

/**
 * Factory providing new connections to xAPI servers.
 */
public interface XApiConnectionFactory {

    /**
     * Establishes a new connection to xAPI server
     *
     * @param host server host
     * @param port server port
     * @return open connection
     * @throws IOException when connection couldn't be open
     */
    XApiConnection newConnection(String host, int port) throws IOException;

}