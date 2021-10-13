package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Welcome {
    private List<Datum> data;
    private Status status;

    @JsonProperty("data")
    public List<Datum> getData() { return data; }
    @JsonProperty("data")
    public void setData(List<Datum> value) { this.data = value; }

    @JsonProperty("status")
    public Status getStatus() { return status; }
    @JsonProperty("status")
    public void setStatus(Status value) { this.status = value; }
}