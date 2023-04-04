package com.olafparfienczyk.xapi.client.codec;

/**
 * Represents a codec used to serialize and deserialize JSON data.
 */
public interface JsonCodec {

    /**
     * Decodes JSON data to java objects.
     *
     * @param encoded JSON data
     * @param type decoded java class
     * @return decoded object
     * @param <T> decoded java type
     * @throws CodecException if decoding fails for any reason
     */
    <T> T decode(String encoded, Class<T> type) throws CodecException;

    /**
     * Encodes java object to JSON string.
     *
     * @param obj java object to encode
     * @return JSON string of encoded object
     * @throws CodecException if encoding fails for any reason
     */
    String encode(Object obj) throws CodecException;

}