package com.olafparfienczyk.xapi.client;

import com.olafparfienczyk.xapi.client.model.SymbolRecord;

import java.io.Closeable;
import java.util.List;

/**
 * A session that implements sync commands. This is the fundamental medium of interaction with xAPI.
 * All operations should be invoked by one thread at a time, since there is no internal concurrency mechanism.
 * If there is need for multithreaded operations creating multiple client is advised.
 * Session should be closed when it's no longer needed to free any underlying resources.
 * <p/>
 * Make sure to abide by xAPI request and connection quotas, as this is not validated out-of-the-box.
 *
 * @see <a href="http://developers.xstore.pro/documentation/#connection-validation">xAPI Protocol Documentation - Connection validation (quotas & limits)</a>
 * @see <a href="http://developers.xstore.pro/documentation">xAPI Protocol Documentation</a>
 */
public interface XApiClient extends Closeable {

    /**
     * Sets the credentials used by this session. It will be used by all sync commands and streams.
     * <p/>
     * If the credentials were changed after the connection was already established, this method will perform a log-out.
     * For this reason it's better to avoid modifying the credentials, as for example all associated streams will
     * be forced to disconnect uncleanly.
     *
     * @param credentials credentials to be used in subsequent operations
     * @see <a href="http://developers.xstore.pro/documentation/#login">xAPI Protocol Documentation - Login</a>
     * @see <a href="http://developers.xstore.pro/documentation/#logout">xAPI Protocol Documentation - Logout</a>
     */
    void setCredentials(XApiCredentials credentials);

    /**
     * Sends {@code ping} command.
     *
     * @throws XApiException raised when command fails to be sent, response can't be read or xAPI responds with an error
     * @see <a href="http://developers.xstore.pro/documentation/#ping">xAPI Protocol Documentation - Ping</a>
     */
    void ping() throws XApiException;

    /**
     * Sends {@code getAllSymbols} command.
     *
     * @throws XApiException raised when command fails to be sent, response can't be read or xAPI responds with an error
     * @return retrieved {@link SymbolRecord}s
     * @see <a href="http://developers.xstore.pro/documentation/#getAllSymbols">xAPI Protocol Documentation - getAllSymbols</a>
     *
     */
    List<SymbolRecord> getAllSymbols() throws XApiException;

    /**
     * Opens a streaming session using provided credentials.
     *
     * @return open streaming session
     * @throws XApiException raised when streaming session couldn't be opened
     */
    XApiStream openStream() throws XApiException;

    /**
     * Closes this session along and frees underlying resources.
     * If there was an established connection, then before it's closed, a log-out is performed.
     *
     * @see <a href="http://developers.xstore.pro/documentation/#logout">xAPI Protocol Documentation - Logout</a>
     */
    void close();

}