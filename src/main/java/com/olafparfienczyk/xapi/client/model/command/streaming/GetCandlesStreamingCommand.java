package com.olafparfienczyk.xapi.client.model.command.streaming;

public class GetCandlesStreamingCommand extends StreamingCommand {

    private String symbol;

    public String getSymbol() {
        return symbol;
    }

    public GetCandlesStreamingCommand setSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }
}