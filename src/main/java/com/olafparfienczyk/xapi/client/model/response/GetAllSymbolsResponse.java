package com.olafparfienczyk.xapi.client.model.response;

import com.olafparfienczyk.xapi.client.model.SymbolRecord;

import java.util.List;

public class GetAllSymbolsResponse extends Response {

    private List<SymbolRecord> returnData;

    public List<SymbolRecord> getReturnData() {
        return returnData;
    }

    public GetAllSymbolsResponse setReturnData(List<SymbolRecord> returnData) {
        this.returnData = returnData;
        return this;
    }
}
