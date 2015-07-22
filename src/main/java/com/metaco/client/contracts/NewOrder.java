package com.metaco.client.contracts;

import java.util.ArrayList;
import java.util.List;

public class NewOrder {
    private String ticker;
    private Integer amountAsset;
    private String recipient;
    private List<String> funding = new ArrayList<String>();
    private String change;
    private String type;
    private String webhook;

    public NewOrder() {
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Integer getAmountAsset() {
        return amountAsset;
    }

    public void setAmountAsset(Integer amountAsset) {
        this.amountAsset = amountAsset;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public List<String> getFunding() {
        return funding;
    }

    public void setFunding(List<String> funding) {
        this.funding = funding;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWebhook() {
        return webhook;
    }

    public void setWebhook(String webhook) {
        this.webhook = webhook;
    }
}
