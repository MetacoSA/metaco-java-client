package com.metaco.api.contracts;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class WalletDetails {
    @SerializedName("timestamp")
    private Integer timestamp;
    @SerializedName("page")
    private PageDetails pageDetails;
    @SerializedName("addresses")
    private List<String> addresses = new ArrayList<String>();
    @SerializedName("value")
    private Long value;
    @SerializedName("balance_bitcoin")
    private Long balanceBitcoin;
    @SerializedName("balances")
    private List<Balance> balances = new ArrayList<Balance>();
    @SerializedName("transactions")
    private List<Transaction> transactions = new ArrayList<Transaction>();

    public WalletDetails() {
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }

    public List<Balance> getBalances() {
        return balances;
    }

    public void setBalances(List<Balance> balances) {
        this.balances = balances;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public PageDetails getPageDetails() {
        return pageDetails;
    }

    public void setPageDetails(PageDetails pageDetails) {
        this.pageDetails = pageDetails;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Long getBalanceBitcoin() {
        return balanceBitcoin;
    }

    public void setBalanceBitcoin(Long balanceBitcoin) {
        this.balanceBitcoin = balanceBitcoin;
    }
}