package com.olafparfienczyk.xapi.client;

import com.olafparfienczyk.xapi.client.codec.Codec;
import com.olafparfienczyk.xapi.client.codec.JacksonCodec;
import com.olafparfienczyk.xapi.client.connection.DefaultXApiConnectionFactory;

public class XApi {

    private XApi() {
    }

    public static XApiClient newClient(XApiConfig config) {
        return newClient(new JacksonCodec(), config);
    }

    public static XApiClient newClient(Codec codec, XApiConfig config) {
        return new XApiClientImpl(new DefaultXApiConnectionFactory(), codec, config);
    }
}