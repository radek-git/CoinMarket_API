package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Datum {
    private long id;
    private String name;
    private String symbol;
    private String slug;
    private Long cmcRank;
    private long numMarketPairs;
    private long circulatingSupply;
    private long totalSupply;
    private long maxSupply;
    private String lastUpdated;
    private String dateAdded;
    private List<String> tags;
    private Object platform;
    private Quote quote;

    @JsonProperty("id")
    public long getID() { return id; }
    @JsonProperty("id")
    public void setID(long value) { this.id = value; }

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

    @JsonProperty("cmc_rank")
    public Long getCmcRank() { return cmcRank; }
    @JsonProperty("cmc_rank")
    public void setCmcRank(Long value) { this.cmcRank = value; }

    @JsonProperty("num_market_pairs")
    public long getNumMarketPairs() { return numMarketPairs; }
    @JsonProperty("num_market_pairs")
    public void setNumMarketPairs(long value) { this.numMarketPairs = value; }

    @JsonProperty("circulating_supply")
    public long getCirculatingSupply() { return circulatingSupply; }
    @JsonProperty("circulating_supply")
    public void setCirculatingSupply(long value) { this.circulatingSupply = value; }

    @JsonProperty("total_supply")
    public long getTotalSupply() { return totalSupply; }
    @JsonProperty("total_supply")
    public void setTotalSupply(long value) { this.totalSupply = value; }

    @JsonProperty("max_supply")
    public long getMaxSupply() { return maxSupply; }
    @JsonProperty("max_supply")
    public void setMaxSupply(long value) { this.maxSupply = value; }

    @JsonProperty("last_updated")
    public String getLastUpdated() { return lastUpdated; }
    @JsonProperty("last_updated")
    public void setLastUpdated(String value) { this.lastUpdated = value; }

    @JsonProperty("date_added")
    public String getDateAdded() { return dateAdded; }
    @JsonProperty("date_added")
    public void setDateAdded(String value) { this.dateAdded = value; }

    @JsonProperty("tags")
    public List<String> getTags() { return tags; }
    @JsonProperty("tags")
    public void setTags(List<String> value) { this.tags = value; }

    @JsonProperty("platform")
    public Object getPlatform() { return platform; }
    @JsonProperty("platform")
    public void setPlatform(Object value) { this.platform = value; }

    @JsonProperty("quote")
    public Quote getQuote() { return quote; }
}