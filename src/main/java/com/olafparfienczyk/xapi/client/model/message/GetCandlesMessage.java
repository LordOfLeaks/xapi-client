package com.olafparfienczyk.xapi.client.model.message;

import com.olafparfienczyk.xapi.client.model.StreamingCandleRecord;

import java.beans.ConstructorProperties;

public class GetCandlesMessage implements Message<StreamingCandleRecord> {

    private final StreamingCandleRecord data;

    @ConstructorProperties("data")
    public GetCandlesMessage(StreamingCandleRecord data) {
        this.data = data;
    }

    @Override
    public StreamingCandleRecord getData() {
        return data;
    }
}