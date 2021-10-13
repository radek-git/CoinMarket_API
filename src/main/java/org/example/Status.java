package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"notice", "total_count"})
//@JsonIgnoreProperties({"total_count"})
public class Status {

    private String timestamp;
    private long errorCode;
    private String errorMessage;
    private long elapsed;
    private long creditCount;

    @JsonProperty("timestamp")
    public String getTimestamp() { return timestamp; }
    @JsonProperty("timestamp")
    public void setTimestamp(String value) { this.timestamp = value; }

    @JsonProperty("error_code")
    public long getErrorCode() { return errorCode; }
    @JsonProperty("error_code")
    public void setErrorCode(long value) { this.errorCode = value; }

    @JsonProperty("error_message")
    public String getErrorMessage() { return errorMessage; }
    @JsonProperty("error_message")
    public void setErrorMessage(String value) { this.errorMessage = value; }

    @JsonProperty("elapsed")
    public long getElapsed() { return elapsed; }
    @JsonProperty("elapsed")
    public void setElapsed(long value) { this.elapsed = value; }

    @JsonProperty("credit_count")
    public long getCreditCount() { return creditCount; }
    @JsonProperty("credit_count")
    public void setCreditCount(long value) { this.creditCount = value; }
}


