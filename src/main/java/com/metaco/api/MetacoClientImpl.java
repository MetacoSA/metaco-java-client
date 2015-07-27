package com.metaco.api;

import com.metaco.api.contracts.*;
import com.metaco.api.exceptions.MetacoClientException;
import com.metaco.api.http.*;
import com.metaco.api.utils.DeserializationUtils;
import com.sun.jersey.api.client.ClientResponse;

import java.util.List;

public class MetacoClientImpl implements MetacoClient {

    protected String metacoApiId;
    protected String metacoApiKey;
    protected String metacoApiUrl;
    protected Boolean metacoTestingMode;

    private String latestDebugData;

    public MetacoClientImpl(MetacoClientBuilder builder) {
        this.metacoApiId = builder.metacoApiId;
        this.metacoApiKey = builder.metacoApiKey;
        this.metacoApiUrl = builder.metacoApiUrl;
        this.metacoTestingMode = builder.metacoTestingMode;
    }

    public AccountRegistrationResult registerAccount(RegisterAccountRequest request) throws MetacoClientException {
        HttpClient client = getHttpClient();

        ClientResponse response = client.doPost("account", request);

        HandleDebugData(response);

        return DeserializationUtils.ToObject(response, AccountRegistrationResult.class);
    }

    public AccountStatus getAccountStatus() throws MetacoClientException {
        HttpClient client = getHttpClient();

        ClientResponse response = client.doGet("account");

        HandleDebugData(response);

        return DeserializationUtils.ToObject(response, AccountStatus.class);
    }

    public void confirmPhoneNumber(ValidateAccountRequest request) throws MetacoClientException  {
        HttpClient client = getHttpClient();

        ClientResponse response = client.doPost("account/confirmation", request);

        HandleDebugData(response);
    }

    public Asset[] getAssets() throws MetacoClientException  {
        HttpClient client = getHttpClient();

        ClientResponse response = client.doGet("assets");

        HandleDebugData(response);

        return DeserializationUtils.ToObject(response,  Asset[].class);
    }

    public Asset getAsset(String ticker) throws MetacoClientException {
        HttpClient client = getHttpClient();

        ClientResponse response = client.doGet(String.format("assets/%s", ticker));

        HandleDebugData(response);

        return DeserializationUtils.ToObject(response, Asset.class);
    }

    public AssetsHistoryResult getAssetsHistory(HistoryCriteria criteria) throws MetacoClientException  {
        return getAssetsHistory(criteria, null);
    }

    public AssetsHistoryResult getAssetsHistory(HistoryCriteria criteria, List<String> tickers) throws MetacoClientException  {
        HttpClient client = getHttpClient();

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

        ClientResponse response = client.doGet(String.format("assets/history?tickers=%s&from=%d&to=%d&freq=%s&orderAsc=%s",
                        tickersStr, criteria.getFrom(), criteria.getTo(), criteria.getFreq(), criteria.getOrderAsc()));

        HandleDebugData(response);

        return DeserializationUtils.ToObject(response, AssetsHistoryResult.class);
    }

    public Order createOrder(NewOrder createOrder) throws MetacoClientException  {
        HttpClient client = getHttpClient();

        ClientResponse response = client.doPost("orders", createOrder);

        HandleDebugData(response);

        return DeserializationUtils.ToObject(response, Order.class);
    }

    public Order[] getOrders() throws MetacoClientException  {
        HttpClient client = getHttpClient();

        ClientResponse response = client.doGet("orders");

        return DeserializationUtils.ToObject(response, Order[].class);
    }

    public Order getOrder(String id) throws MetacoClientException  {
        HttpClient client = getHttpClient();

        ClientResponse response = client.doGet(String.format("orders/%s", id));

        HandleDebugData(response);

        return DeserializationUtils.ToObject(response, Order.class);
    }

    public Order submitSignedOrder(String id, RawTransaction rawTransaction) throws MetacoClientException  {
        HttpClient client = getHttpClient();

        ClientResponse response = client.doPost(String.format("orders/%s", id), rawTransaction);

        HandleDebugData(response);

        return DeserializationUtils.ToObject(response, Order.class);
    }

    public void cancelOrder(String id) throws MetacoClientException  {
        HttpClient client = getHttpClient();

        ClientResponse response = client.doDelete(String.format("orders/%s", id));

        HandleDebugData(response);
    }

    public TransactionToSign createTransaction(NewTransaction newTransaction) throws MetacoClientException {
        HttpClient client = getHttpClient();

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
        queryStringBuilder.delete(queryStringBuilder.length() - 1, queryStringBuilder.length());

        ClientResponse response = client.doGet("transactions/raw" + queryStringBuilder.toString());

        HandleDebugData(response);

        return DeserializationUtils.ToObject(response, TransactionToSign.class);
    }

    public TransactionBroadcastResult broadcastTransaction(RawTransaction rawTransaction) throws MetacoClientException {
        HttpClient client = getHttpClient();

        ClientResponse response = client.doPost("transactions", rawTransaction);

        HandleDebugData(response);

        return DeserializationUtils.ToObject(response, TransactionBroadcastResult.class);
    }

    public WalletDetails getWalletDetails(List<String> addresses) throws MetacoClientException {
        HttpClient client = getHttpClient();

        StringBuilder builder = new StringBuilder();
        for(int i = 0 ; i < addresses.size() ; i ++ ){
            builder.append(addresses.get(i));
            if(i != addresses.size() - 1){
                builder.append(',');
            }
        }

        ClientResponse response = client.doGet(String.format("transactions/%s", builder));

        HandleDebugData(response);

        return DeserializationUtils.ToObject(response, WalletDetails.class);
    }

    private <T> HttpClient getHttpClient() {
        return new HttpClientImpl(this.metacoApiId, this.metacoApiKey, this.metacoApiUrl, this.metacoTestingMode);
    }

    private void HandleDebugData(ClientResponse response) {
        latestDebugData = null;
        String debugData = response.getHeaders().getFirst("X-Metaco-DebugData");
        if (debugData != null && !debugData.equals("")) {
            latestDebugData = debugData;
        }
    }

    public String getLatestDebugData() {
        return latestDebugData;
    }
}
