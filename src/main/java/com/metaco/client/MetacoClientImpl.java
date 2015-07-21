package com.metaco.client;

import com.google.gson.Gson;
import com.metaco.client.entity.*;
import com.metaco.client.entity.NewOrder;
import com.metaco.client.entity.HistoryCriteria;
import com.metaco.client.entity.AccountRegistrationResult;
import com.metaco.client.entity.AssetsHistoryResult;
import com.metaco.client.entity.WalletDetails;
import com.metaco.client.http.*;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.util.List;

class MetacoClientImpl implements MetacoClient {

    protected String metacoApiId;
    protected String metacoApiKey;
    protected String metacoApiUrl;
    protected Boolean metacoTestingMode;

    MetacoClientImpl(MetacoClientBuilder builder) {
        this.metacoApiId = builder.metacoApiId;
        this.metacoApiKey = builder.metacoApiKey;
        this.metacoApiUrl = builder.metacoApiUrl;
        this.metacoTestingMode = builder.metacoTestingMode;
    }

    public AccountRegistrationResult RegisterAccount(String phoneNumber) {
        return null;
    }

    public AccountStatus GetAccountStatus() {
        return null;
    }

    public void ConfirmPhoneNumber(String validationCode) {

    }

    public Asset[] GetAssets() {
        return null;
    }

    public Asset GetAsset(String ticker) {
        HttpClient client = getHttpClient();

        client.
    }

    public AssetsHistoryResult GetAssetsHistory(HistoryCriteria criteria) {
        return null;
    }

    public AssetHistory GetAssetHistory(String ticker, HistoryCriteria criteria) {
        return null;
    }

    public Order CreateOrder(NewOrder createOrder) {
        return null;
    }

    public List<Order> GetOrders() {
        return null;
    }

    public Order GetOrder(String id) {
        return null;
    }

    public Order SubmitSignedOrder(String id, RawTransaction rawTransaction) {
        return null;
    }

    public void CancelOrder(String id) {

    }

    public TransactionToSign CreateTransaction() {
        return null;
    }

    public void BroadcastTransaction(RawTransaction rawTransaction) {

    }

    public WalletDetails GetWalletDetails() {
        return null;
    }

    private HttpClient getHttpClient() {
        return new HttpClientBuilder()
                .withApiId(metacoApiId)
                .withApiKey(metacoApiKey)
                .withApiUrl(metacoApiUrl)
                .withTestingMode(metacoTestingMode)
                .makeClient();
    }
}
