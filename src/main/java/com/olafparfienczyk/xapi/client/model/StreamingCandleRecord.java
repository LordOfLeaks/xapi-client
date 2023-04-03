package com.olafparfienczyk.xapi.client.model;

import java.beans.ConstructorProperties;
import java.math.BigDecimal;
import java.time.Instant;

public class StreamingCandleRecord {

    private final BigDecimal close;
    private final Instant ctm;
    private final String ctmString;
    private final BigDecimal high;
    private final BigDecimal low;
    private final BigDecimal open;
    private final int quoteId;
    private final String symbol;
    private final BigDecimal vol;

    @ConstructorProperties({"close", "ctm", "ctmString", "high", "low", "open", "quoteId", "symbol", "vol"})
    public StreamingCandleRecord(BigDecimal close,
                                 Instant ctm,
                                 String ctmString,
                                 BigDecimal high,
                                 BigDecimal low,
                                 BigDecimal open,
                                 int quoteId,
                                 String symbol,
                                 BigDecimal vol) {
        this.close = close;
        this.ctm = ctm;
        this.ctmString = ctmString;
        this.high = high;
        this.low = low;
        this.open = open;
        this.quoteId = quoteId;
        this.symbol = symbol;
        this.vol = vol;
    }

    public BigDecimal getClose() {
        return close;
    }

    public Instant getCtm() {
        return ctm;
    }

    public String getCtmString() {
        return ctmString;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public int getQuoteId() {
        return quoteId;
    }

    public String getSymbol() {
        return symbol;
    }

    public BigDecimal getVol() {
        return vol;
    }
}