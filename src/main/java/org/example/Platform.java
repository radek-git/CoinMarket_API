package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Platform {

    private long id;
    private String name;
    private String symbol;
    private String slug;
    private String tokenAddress;

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

    @JsonProperty("token_address")
    public String getTokenAddress() { return tokenAddress; }
    @JsonProperty("token_address")
    public void setTokenAddress(String value) { this.tokenAddress = value; }
}
