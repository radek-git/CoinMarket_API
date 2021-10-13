package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties({"percent_change_30d", "percent_change_60d", "percent_change_90d", "market_cap_dominance",
        "fully_diluted_market_cap"})
public class Usd {

    private double price;
    private long volume24H;
    private double percentChange1H;
    private double percentChange24H;
    private double percentChange7D;
    private long marketCap;
    private String lastUpdated;

    @JsonProperty("price")
    public double getPrice() { return price; }
    @JsonProperty("price")
    public void setPrice(double value) { this.price = value; }

    @JsonProperty("volume_24h")
    public long getVolume24H() { return volume24H; }
    @JsonProperty("volume_24h")
    public void setVolume24H(long value) { this.volume24H = value; }

    @JsonProperty("percent_change_1h")
    public double getPercentChange1H() { return percentChange1H; }
    @JsonProperty("percent_change_1h")
    public void setPercentChange1H(double value) { this.percentChange1H = value; }

    @JsonProperty("percent_change_24h")
    public double getPercentChange24H() { return percentChange24H; }
    @JsonProperty("percent_change_24h")
    public void setPercentChange24H(double value) { this.percentChange24H = value; }

    @JsonProperty("percent_change_7d")
    public double getPercentChange7D() { return percentChange7D; }
    @JsonProperty("percent_change_7d")
    public void setPercentChange7D(double value) { this.percentChange7D = value; }

    @JsonProperty("market_cap")
    public long getMarketCap() { return marketCap; }
    @JsonProperty("market_cap")
    public void setMarketCap(long value) { this.marketCap = value; }

    @JsonProperty("last_updated")
    public String getLastUpdated() { return lastUpdated; }
    @JsonProperty("last_updated")
    public void setLastUpdated(String value) { this.lastUpdated = value; }
}
