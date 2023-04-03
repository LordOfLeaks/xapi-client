package com.olafparfienczyk.xapi.client.model.response;

public class LoginResponse extends Response {

    private String streamSessionId;

    public String getStreamSessionId() {
        return streamSessionId;
    }

    public LoginResponse setStreamSessionId(String streamSessionId) {
        this.streamSessionId = streamSessionId;
        return this;
    }
}