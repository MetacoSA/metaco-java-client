package com.metaco.api.contracts;

import com.google.gson.annotations.SerializedName;

public class MaxYearlyChfOrder {
    @SerializedName("remaining")
    private Long remaining;
    @SerializedName("current")
    private Long current;
    @SerializedName("max")
    private Long max;

    public MaxYearlyChfOrder() {
    }

    public Long getRemaining() {
        return remaining;
    }

    public void setRemaining(Long remaining) {
        this.remaining = remaining;
    }

    public Long getCurrent() {
        return current;
    }

    public void setCurrent(Long current) {
        this.current = current;
    }

    public Long getMax() {
        return max;
    }

    public void setMax(Long max) {
        this.max = max;
    }
}
