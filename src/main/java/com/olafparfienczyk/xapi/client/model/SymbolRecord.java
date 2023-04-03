package com.olafparfienczyk.xapi.client.model;

import java.math.BigDecimal;
import java.time.Instant;

public class SymbolRecord {

    private BigDecimal ask;
    private BigDecimal bid;
    private String categoryName;
    private int contractSize;
    private String currency;
    private boolean currencyPair;
    private String currencyProfit;
    private String description;
    private Instant expiration;
    private String groupName;
    private BigDecimal high;
    private int initialMargin;
    private int instantMaxVolume;
    private BigDecimal leverage;
    private boolean longOnly;
    private BigDecimal lotMax;
    private BigDecimal lotMin;
    private BigDecimal lotStep;
    private BigDecimal low;
    private int marginHedged;
    private boolean marginHedgedStrong;
    private int marginMaintenance;
    private int marginMode;
    private BigDecimal percentage;
    private int pipsPrecision;
    private int precision;
    private int profitMode;
    private BigDecimal quoteId;
    private boolean shortSelling;
    private BigDecimal spreadRaw;
    private BigDecimal spreadTable;
    private Instant starting;
    private int stepRuleId;
    private int stopsLevel;
    private int swap_rollover3days;
    private boolean swapEnable;
    private BigDecimal swapLong;
    private BigDecimal swapShort;
    private int swapType;
    private String symbol;
    private BigDecimal tickSize;
    private BigDecimal tickValue;
    private Instant time;
    private boolean trailingEnabled;
    private int type;

    public BigDecimal getAsk() {
        return ask;
    }

    public SymbolRecord setAsk(BigDecimal ask) {
        this.ask = ask;
        return this;
    }

    public BigDecimal getBid() {
        return bid;
    }

    public SymbolRecord setBid(BigDecimal bid) {
        this.bid = bid;
        return this;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public SymbolRecord setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public int getContractSize() {
        return contractSize;
    }

    public SymbolRecord setContractSize(int contractSize) {
        this.contractSize = contractSize;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public SymbolRecord setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public boolean isCurrencyPair() {
        return currencyPair;
    }

    public SymbolRecord setCurrencyPair(boolean currencyPair) {
        this.currencyPair = currencyPair;
        return this;
    }

    public String getCurrencyProfit() {
        return currencyProfit;
    }

    public SymbolRecord setCurrencyProfit(String currencyProfit) {
        this.currencyProfit = currencyProfit;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SymbolRecord setDescription(String description) {
        this.description = description;
        return this;
    }

    public Instant getExpiration() {
        return expiration;
    }

    public SymbolRecord setExpiration(Instant expiration) {
        this.expiration = expiration;
        return this;
    }

    public String getGroupName() {
        return groupName;
    }

    public SymbolRecord setGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public SymbolRecord setHigh(BigDecimal high) {
        this.high = high;
        return this;
    }

    public int getInitialMargin() {
        return initialMargin;
    }

    public SymbolRecord setInitialMargin(int initialMargin) {
        this.initialMargin = initialMargin;
        return this;
    }

    public int getInstantMaxVolume() {
        return instantMaxVolume;
    }

    public SymbolRecord setInstantMaxVolume(int instantMaxVolume) {
        this.instantMaxVolume = instantMaxVolume;
        return this;
    }

    public BigDecimal getLeverage() {
        return leverage;
    }

    public SymbolRecord setLeverage(BigDecimal leverage) {
        this.leverage = leverage;
        return this;
    }

    public boolean isLongOnly() {
        return longOnly;
    }

    public SymbolRecord setLongOnly(boolean longOnly) {
        this.longOnly = longOnly;
        return this;
    }

    public BigDecimal getLotMax() {
        return lotMax;
    }

    public SymbolRecord setLotMax(BigDecimal lotMax) {
        this.lotMax = lotMax;
        return this;
    }

    public BigDecimal getLotMin() {
        return lotMin;
    }

    public SymbolRecord setLotMin(BigDecimal lotMin) {
        this.lotMin = lotMin;
        return this;
    }

    public BigDecimal getLotStep() {
        return lotStep;
    }

    public SymbolRecord setLotStep(BigDecimal lotStep) {
        this.lotStep = lotStep;
        return this;
    }

    public BigDecimal getLow() {
        return low;
    }

    public SymbolRecord setLow(BigDecimal low) {
        this.low = low;
        return this;
    }

    public int getMarginHedged() {
        return marginHedged;
    }

    public SymbolRecord setMarginHedged(int marginHedged) {
        this.marginHedged = marginHedged;
        return this;
    }

    public boolean isMarginHedgedStrong() {
        return marginHedgedStrong;
    }

    public SymbolRecord setMarginHedgedStrong(boolean marginHedgedStrong) {
        this.marginHedgedStrong = marginHedgedStrong;
        return this;
    }

    public int getMarginMaintenance() {
        return marginMaintenance;
    }

    public SymbolRecord setMarginMaintenance(int marginMaintenance) {
        this.marginMaintenance = marginMaintenance;
        return this;
    }

    public int getMarginMode() {
        return marginMode;
    }

    public SymbolRecord setMarginMode(int marginMode) {
        this.marginMode = marginMode;
        return this;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public SymbolRecord setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
        return this;
    }

    public int getPipsPrecision() {
        return pipsPrecision;
    }

    public SymbolRecord setPipsPrecision(int pipsPrecision) {
        this.pipsPrecision = pipsPrecision;
        return this;
    }

    public int getPrecision() {
        return precision;
    }

    public SymbolRecord setPrecision(int precision) {
        this.precision = precision;
        return this;
    }

    public int getProfitMode() {
        return profitMode;
    }

    public SymbolRecord setProfitMode(int profitMode) {
        this.profitMode = profitMode;
        return this;
    }

    public BigDecimal getQuoteId() {
        return quoteId;
    }

    public SymbolRecord setQuoteId(BigDecimal quoteId) {
        this.quoteId = quoteId;
        return this;
    }

    public boolean isShortSelling() {
        return shortSelling;
    }

    public SymbolRecord setShortSelling(boolean shortSelling) {
        this.shortSelling = shortSelling;
        return this;
    }

    public BigDecimal getSpreadRaw() {
        return spreadRaw;
    }

    public SymbolRecord setSpreadRaw(BigDecimal spreadRaw) {
        this.spreadRaw = spreadRaw;
        return this;
    }

    public BigDecimal getSpreadTable() {
        return spreadTable;
    }

    public SymbolRecord setSpreadTable(BigDecimal spreadTable) {
        this.spreadTable = spreadTable;
        return this;
    }

    public Instant getStarting() {
        return starting;
    }

    public SymbolRecord setStarting(Instant starting) {
        this.starting = starting;
        return this;
    }

    public int getStepRuleId() {
        return stepRuleId;
    }

    public SymbolRecord setStepRuleId(int stepRuleId) {
        this.stepRuleId = stepRuleId;
        return this;
    }

    public int getStopsLevel() {
        return stopsLevel;
    }

    public SymbolRecord setStopsLevel(int stopsLevel) {
        this.stopsLevel = stopsLevel;
        return this;
    }

    public int getSwap_rollover3days() {
        return swap_rollover3days;
    }

    public SymbolRecord setSwap_rollover3days(int swap_rollover3days) {
        this.swap_rollover3days = swap_rollover3days;
        return this;
    }

    public boolean isSwapEnable() {
        return swapEnable;
    }

    public SymbolRecord setSwapEnable(boolean swapEnable) {
        this.swapEnable = swapEnable;
        return this;
    }

    public BigDecimal getSwapLong() {
        return swapLong;
    }

    public SymbolRecord setSwapLong(BigDecimal swapLong) {
        this.swapLong = swapLong;
        return this;
    }

    public BigDecimal getSwapShort() {
        return swapShort;
    }

    public SymbolRecord setSwapShort(BigDecimal swapShort) {
        this.swapShort = swapShort;
        return this;
    }

    public int getSwapType() {
        return swapType;
    }

    public SymbolRecord setSwapType(int swapType) {
        this.swapType = swapType;
        return this;
    }

    public String getSymbol() {
        return symbol;
    }

    public SymbolRecord setSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public BigDecimal getTickSize() {
        return tickSize;
    }

    public SymbolRecord setTickSize(BigDecimal tickSize) {
        this.tickSize = tickSize;
        return this;
    }

    public BigDecimal getTickValue() {
        return tickValue;
    }

    public SymbolRecord setTickValue(BigDecimal tickValue) {
        this.tickValue = tickValue;
        return this;
    }

    public Instant getTime() {
        return time;
    }

    public SymbolRecord setTime(Instant time) {
        this.time = time;
        return this;
    }

    public boolean isTrailingEnabled() {
        return trailingEnabled;
    }

    public SymbolRecord setTrailingEnabled(boolean trailingEnabled) {
        this.trailingEnabled = trailingEnabled;
        return this;
    }

    public int getType() {
        return type;
    }

    public SymbolRecord setType(int type) {
        this.type = type;
        return this;
    }
}