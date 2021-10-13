package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {

    private long id;
    private long rank;
    private String name;
    private String symbol;
    private String slug;
    private long isActive;
    private String firstHistoricalData;
    private String lastHistoricalData;
    private Platform platform;

    @JsonProperty("id")
    public long getID() { return id; }
    @JsonProperty("id")
    public void setID(long value) { this.id = value; }

    @JsonProperty("rank")
    public long getRank() { return rank; }
    @JsonProperty("rank")
    public void setRank(long value) { this.rank = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("symbol")
    public String getSymbol() { return symbol; }
    @JsonProperty("symbol")
    public void setSymbol(String value) { this.symbol = value; }

    @JsonProperty("slug")
    public String getSlug() { return slug; }
    @JsonProperty("slug")
    public void setSlug(String value) { this.slug = value; }

    @JsonProperty("is_active")
    public long getIsActive() { return isActive; }
    @JsonProperty("is_active")
    public void setIsActive(long value) { this.isActive = value; }

    @JsonProperty("first_historical_data")
    public String getFirstHistoricalData() { return firstHistoricalData; }
    @JsonProperty("first_historical_data")
    public void setFirstHistoricalData(String value) { this.firstHistoricalData = value; }

    @JsonProperty("last_historical_data")
    public String getLastHistoricalData() { return lastHistoricalData; }
    @JsonProperty("last_historical_data")
    public void setLastHistoricalData(String value) { this.lastHistoricalData = value; }

    @JsonProperty("platform")
    public Platform getPlatform() { return platform; }
    @JsonProperty("platform")
    public void setPlatform(Platform value) { this.platform = value; }
}
