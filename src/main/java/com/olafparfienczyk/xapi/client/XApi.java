package com.olafparfienczyk.xapi.client;

import com.olafparfienczyk.xapi.client.codec.JsonCodec;
import com.olafparfienczyk.xapi.client.codec.JacksonJsonCodec;
import com.olafparfienczyk.xapi.client.connection.DefaultXApiConnectionFactory;

/**
 * Static factory to provide new clients.
 */
public class XApi {

    private XApi() {
    }

    /**
     * Creates a new client with given config.
     *
     * @param config client's config
     * @return newly created client
     */
    public static XApiClient newClient(XApiConfig config) {
        return newClient(new JacksonJsonCodec(), config);
    }

    /**
     * Creates a new client with given config and JSON codec.
     *
     * @param jsonCodec JSON codec to be used by client
     * @param config client's config
     * @return newly created client
     */
    public static XApiClient newClient(JsonCodec jsonCodec, XApiConfig config) {
        return new XApiClientImpl(new DefaultXApiConnectionFactory(), jsonCodec, config);
    }
}