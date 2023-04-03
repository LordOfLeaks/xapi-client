package com.olafparfienczyk.xapi.client;

import com.olafparfienczyk.xapi.client.model.SymbolRecord;

import java.io.Closeable;
import java.util.List;

public interface XApiClient extends Closeable {

    void setCredentials(XApiCredentials credentials);

    void ping() throws XApiException;

    List<SymbolRecord> getAllSymbols() throws XApiException;

    XApiStream openStream() throws XApiException;

    void close();

}