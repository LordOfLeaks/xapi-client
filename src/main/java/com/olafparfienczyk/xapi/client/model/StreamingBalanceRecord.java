package com.olafparfienczyk.xapi.client.model;

import java.beans.ConstructorProperties;
import java.math.BigDecimal;

public class StreamingBalanceRecord {

    private final BigDecimal balance;
    private final BigDecimal credit;
    private final BigDecimal equity;
    private final BigDecimal margin;
    private final BigDecimal marginFree;
    private final BigDecimal marginLevel;

    @ConstructorProperties({"balance", "credit", "equity", "margin", "marginFree", "marginLevel"})
    public StreamingBalanceRecord(
            BigDecimal balance,
            BigDecimal credit,
            BigDecimal equity,
            BigDecimal margin,
            BigDecimal marginFree,
            BigDecimal marginLevel) {
        this.balance = balance;
        this.credit = credit;
        this.equity = equity;
        this.margin = margin;
        this.marginFree = marginFree;
        this.marginLevel = marginLevel;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public BigDecimal getEquity() {
        return equity;
    }

    public BigDecimal getMargin() {
        return margin;
    }

    public BigDecimal getMarginFree() {
        return marginFree;
    }

    public BigDecimal getMarginLevel() {
        return marginLevel;
    }
}