package com.olafparfienczyk.xapi.client;

public class XApiException extends Exception {

    public XApiException(String message) {
        super(message);
    }

    public XApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
