package com.olafparfienczyk.xapi.client;

public interface StreamListener<T> {

    void onMessage(T data);

}