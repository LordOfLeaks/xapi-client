package com.olafparfienczyk.xapi.client.codec;

public interface Codec {

    <T> T decode(String encoded, Class<T> type) throws CodecException;

    String encode(Object obj) throws CodecException;

}