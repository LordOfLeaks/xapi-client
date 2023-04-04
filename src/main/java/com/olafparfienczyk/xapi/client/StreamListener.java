package com.olafparfienczyk.xapi.client;

import com.olafparfienczyk.xapi.client.model.message.Message;

/**
 * Represents a listener to streaming message of given type.
 *
 * @param <T> message type
 */
public interface StreamListener<T extends Message<?>> {

    /**
     * Called to notify of incoming message.
     * @param message incoming message
     */
    void onMessage(T message);

}