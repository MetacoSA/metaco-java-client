package com.metaco.api.contracts;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class NewOrder {
    @SerializedName("type")
    private String type;
    @SerializedName("ticker")
    private String ticker;
    @SerializedName("amount_asset")
    private Long amountAsset;
    @SerializedName("amount_satoshi")
    private Long amountSatoshi;
    @SerializedName("recipient")
    private String recipient;
    @SerializedName("funding")
    private List<String> funding = new ArrayList<String>();
    @SerializedName("change")
    private String change;
    @SerializedName("webhook")
    private String webhook;

    public NewOrder() {
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Long getAmountAsset() {
        return amountAsset;
    }

    public void setAmountAsset(Long amountAsset) {
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

    public Long getAmountSatoshi() {
        return amountSatoshi;
    }

    public void setAmountSatoshi(Long amountSatoshi) {
        this.amountSatoshi = amountSatoshi;
    }
}
