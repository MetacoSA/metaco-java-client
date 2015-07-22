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

        return client.DoPost("account", request, AccountRegistrationResult.class);
    }

    public AccountStatus getAccountStatus() throws MetacoClientException {
        HttpClient<AccountStatus> client = getHttpClient();

        return client.DoGet("account", AccountStatus.class);
    }

    public void confirmPhoneNumber(ValidateAccountRequest request) throws MetacoClientException  {
        HttpClient client = getHttpClient();
        client.DoPost("account", request);
    }

    public Asset[] getAssets() throws MetacoClientException  {
        HttpClient<Asset[]> client = getHttpClient();

        return client.DoGet("assets", Asset[].class);
    }

    public Asset getAsset(String ticker) throws MetacoClientException {
        HttpClient<Asset> client = getHttpClient();

        return client.DoGet(String.format("assets/%s", ticker), Asset.class);
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

        return client.DoGet(String.format("assets/history?tickers=%s&from=%d&to=%d&freq=%s&orderAsc=%s",
                tickersStr, criteria.getFrom(), criteria.getTo(), criteria.getFreq(), criteria.getOrderAsc()),
                AssetsHistoryResult.class);
    }

    public Order createOrder(NewOrder createOrder) throws MetacoClientException  {
        HttpClient<Order> client = getHttpClient();

        return client.DoPost("orders", createOrder, Order.class);
    }

    public Order[] getOrders() throws MetacoClientException  {
        HttpClient<Order[]> client = getHttpClient();

        return client.DoGet("orders", Order[].class);
    }

    public Order getOrder(String id) throws MetacoClientException  {
        HttpClient<Order> client = getHttpClient();

        return client.DoGet(String.format("orders/%s", id), Order.class);
    }

    public Order submitSignedOrder(String id, RawTransaction rawTransaction) throws MetacoClientException  {
        HttpClient<Order> client = getHttpClient();

        return client.DoPost(String.format("orders/%s", id), rawTransaction, Order.class);
    }

    public void cancelOrder(String id) throws MetacoClientException  {
        HttpClient<Order> client = getHttpClient();

        client.DoDelete(String.format("orders/%s", id), null);
    }

    public TransactionToSign createTransaction() throws MetacoClientException {
        return null;
    }

    public void broadcastTransaction(RawTransaction rawTransaction) throws MetacoClientException {

    }

    public WalletDetails getWalletDetails() throws MetacoClientException {
        return null;
    }

    private <T> HttpClient<T> getHttpClient() {
        return new HttpClientImpl<T>(this.metacoApiId, this.metacoApiKey, this.metacoApiUrl, this.metacoTestingMode);
    }
}
