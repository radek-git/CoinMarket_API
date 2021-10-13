package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CryptocurrencyMapResponse {

    private List<Data> data;
    private Status status;

    @JsonProperty("data")
    public List<Data> getDatum() { return data; }
    @JsonProperty("data")
    public void setData(List<Data> value) { this.data = value; }

    @JsonProperty("status")
    public Status getStatus() { return status; }
    @JsonProperty("status")
    public void setStatus(Status value) { this.status = value; }
}
