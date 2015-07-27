package com.metaco.api.contracts;

import java.math.BigDecimal;

public class MaxYearlyChfOrder {
    private BigDecimal remaining;
    private BigDecimal current;
    private BigDecimal max;

    public MaxYearlyChfOrder() {
    }

    public BigDecimal getRemaining() {
        return remaining;
    }

    public void setRemaining(BigDecimal remaining) {
        this.remaining = remaining;
    }

    public BigDecimal getCurrent() {
        return current;
    }

    public void setCurrent(BigDecimal current) {
        this.current = current;
    }

    public BigDecimal getMax() {
        return max;
    }

    public void setMax(BigDecimal max) {
        this.max = max;
    }
}
