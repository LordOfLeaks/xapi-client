package com.olafparfienczyk.xapi.client.model.response;

public class Response {

    private boolean status;
    private String errorCode;
    private String errorDescr;

    public boolean isStatus() {
        return status;
    }

    public Response setStatus(boolean status) {
        this.status = status;
        return this;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public Response setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public String getErrorDescr() {
        return errorDescr;
    }

    public Response setErrorDescr(String errorDescr) {
        this.errorDescr = errorDescr;
        return this;
    }
}
