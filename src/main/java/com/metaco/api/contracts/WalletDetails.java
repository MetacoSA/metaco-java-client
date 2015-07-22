package com.metaco.api.contracts;

import java.util.ArrayList;
import java.util.List;

public class WalletDetails {
    private Integer timestamp;
    private List<String> addresses = new ArrayList<String>();
    private Integer value;
    private Integer balance_bitcoin;
    private List<Balance> balances = new ArrayList<Balance>();
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

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getBalance_bitcoin() {
        return balance_bitcoin;
    }

    public void setBalance_bitcoin(Integer balance_bitcoin) {
        this.balance_bitcoin = balance_bitcoin;
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
}