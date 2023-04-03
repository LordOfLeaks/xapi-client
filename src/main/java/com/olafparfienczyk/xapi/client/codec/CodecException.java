package com.olafparfienczyk.xapi.client.codec;

import java.io.IOException;

public class CodecException extends IOException {

    public CodecException(String message) {
        super(message);
    }

    public CodecException(String message, Throwable cause) {
        super(message, cause);
    }
}