package com.metaco.client.contracts;

import java.util.ArrayList;
import java.util.List;

public class WalletDetails {
    private Integer timestamp;
    private List<String> addresses = new ArrayList<String>();
    private Integer value;
    private Integer balanceBitcoin;
    private List<Balance> balances = new ArrayList<Balance>();
    private List<Transaction> transactions = new ArrayList<Transaction>();
}