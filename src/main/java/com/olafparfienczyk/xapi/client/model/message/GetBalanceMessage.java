package com.olafparfienczyk.xapi.client.model.message;

import com.olafparfienczyk.xapi.client.model.StreamingBalanceRecord;

import java.beans.ConstructorProperties;

public class GetBalanceMessage implements Message<StreamingBalanceRecord> {

    private final StreamingBalanceRecord data;

    @ConstructorProperties("data")
    public GetBalanceMessage(StreamingBalanceRecord data) {
        this.data = data;
    }

    @Override
    public StreamingBalanceRecord getData() {
        return data;
    }
}