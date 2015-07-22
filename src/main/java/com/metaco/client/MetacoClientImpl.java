package com.metaco.client;

import com.metaco.client.contracts.*;
import com.metaco.client.exceptions.MetacoClientException;
import com.metaco.client.http.*;

import java.util.List;

public class MetacoClientImpl implements MetacoClient {

    protected String metacoApiId;
    protected String metacoApiKey;
    protected String metacoApiUrl;
    protected Boolean metacoTestingMode;

    public MetacoClientImpl(MetacoClientBuilder builder) {
        this.metacoApiId = builder.metacoApiId;
        this.metacoApiKey = builder.metacoApiKey;
        this.metacoApiUrl = builder.metacoApiUrl;
        this.metacoTestingMode = builder.metacoTestingMode;
    }

    public AccountRegistrationResult registerAccount(RegisterAccountRequest request) throws MetacoClientException {
        HttpClient<AccountRegistrationResult> client = getHttpClient();

        return client.doPost("account", request, AccountRegistrationResult.class);
    }

    public AccountStatus getAccountStatus() throws MetacoClientException {
        HttpClient<AccountStatus> client = getHttpClient();

        return client.doGet("account", AccountStatus.class);
    }

    public void confirmPhoneNumber(ValidateAccountRequest request) throws MetacoClientException  {
        HttpClient client = getHttpClient();
        client.doPost("account", request);
    }

    public Asset[] getAssets() throws MetacoClientException  {
        HttpClient<Asset[]> client = getHttpClient();

        return client.doGet("assets", Asset[].class);
    }

    public Asset getAsset(String ticker) throws MetacoClientException {
        HttpClient<Asset> client = getHttpClient();

        return client.doGet(String.format("assets/%s", ticker), Asset.class);
    }

    public AssetsHistoryResult getAssetsHistory(HistoryCriteria criteria) throws MetacoClientException  {
        return getAssetsHistory(criteria, null);
    }

    public AssetsHistoryResult getAssetsHistory(HistoryCriteria criteria, List<String> tickers) throws MetacoClientException  {
        HttpClient<AssetsHistoryResult> client = getHttpClient();

        String tickersStr;

        if (tickers != null && !tickers.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            for(int i = 0 ; i < tickers.size() ; i ++ ){
                builder.append(tickers.get(i));
                if(i != tickers.size() - 1){
                    builder.append(',');
                }
            }
            tickersStr = builder.toString();
        } else {
            tickersStr = "all";
        }

        return client.doGet(String.format("assets/history?tickers=%s&from=%d&to=%d&freq=%s&orderAsc=%s",
                        tickersStr, criteria.getFrom(), criteria.getTo(), criteria.getFreq(), criteria.getOrderAsc()),
                AssetsHistoryResult.class);
    }

    public Order createOrder(NewOrder createOrder) throws MetacoClientException  {
        HttpClient<Order> client = getHttpClient();

        return client.doPost("orders", createOrder, Order.class);
    }

    public Order[] getOrders() throws MetacoClientException  {
        HttpClient<Order[]> client = getHttpClient();

        return client.doGet("orders", Order[].class);
    }

    public Order getOrder(String id) throws MetacoClientException  {
        HttpClient<Order> client = getHttpClient();

        return client.doGet(String.format("orders/%s", id), Order.class);
    }

    public Order submitSignedOrder(String id, RawTransaction rawTransaction) throws MetacoClientException  {
        HttpClient<Order> client = getHttpClient();

        return client.doPost(String.format("orders/%s", id), rawTransaction, Order.class);
    }

    public void cancelOrder(String id) throws MetacoClientException  {
        HttpClient<Order> client = getHttpClient();

        client.doDelete(String.format("orders/%s", id), null);
    }

    public TransactionToSign createTransaction(NewTransaction newTransaction) throws MetacoClientException {
        HttpClient<TransactionToSign> client = getHttpClient();

        StringBuilder queryStringBuilder = new StringBuilder();
        queryStringBuilder.append("?");

        if (newTransaction.getAmount_asset() != null) {
            queryStringBuilder.append(String.format("amount_asset=%d&", newTransaction.getAmount_asset()));
        }
        if (newTransaction.getAmount_satoshi() != null) {
            queryStringBuilder.append(String.format("amount_satoshi=%d&", newTransaction.getAmount_satoshi()));
        }
        if (newTransaction.getChange() != null) {
            queryStringBuilder.append(String.format("change=%s&", newTransaction.getChange()));
        }
        if (newTransaction.getFrom() != null) {
            queryStringBuilder.append(String.format("from=%s&", newTransaction.getFrom()));
        }
        if (newTransaction.getTo() != null) {
            queryStringBuilder.append(String.format("to=%s&", newTransaction.getTo()));
        }
        if (newTransaction.getTicker() != null) {
            queryStringBuilder.append(String.format("ticker=%s&", newTransaction.getTicker()));
        }
        if (newTransaction.getFeePerKB() != null) {
            queryStringBuilder.append(String.format("feePerKB=%f&", newTransaction.getFeePerKB()));
        }
        queryStringBuilder.delete(queryStringBuilder.length()-1, queryStringBuilder.length());

        return client.doGet("transactions/raw" + queryStringBuilder.toString(), TransactionToSign.class);
    }

    public TransactionBroadcastResult broadcastTransaction(RawTransaction rawTransaction) throws MetacoClientException {
        HttpClient<TransactionBroadcastResult> client = getHttpClient();

        return client.doPost("transactions", rawTransaction, TransactionBroadcastResult.class);
    }

    public WalletDetails getWalletDetails(List<String> addresses) throws MetacoClientException {
        HttpClient<WalletDetails> client = getHttpClient();

        StringBuilder builder = new StringBuilder();
        for(int i = 0 ; i < addresses.size() ; i ++ ){
            builder.append(addresses.get(i));
            if(i != addresses.size() - 1){
                builder.append(',');
            }
        }

        return client.doGet(String.format("transactions/%s", builder), WalletDetails.class);
    }

    private <T> HttpClient<T> getHttpClient() {
        return new HttpClientImpl<T>(this.metacoApiId, this.metacoApiKey, this.metacoApiUrl, this.metacoTestingMode);
    }
}
