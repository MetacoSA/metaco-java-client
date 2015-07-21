package com.metaco.client;

import com.metaco.client.entity.*;
import com.metaco.client.entity.NewOrder;
import com.metaco.client.entity.HistoryCriteria;
import com.metaco.client.entity.AccountRegistrationResult;
import com.metaco.client.entity.AssetsHistoryResult;
import com.metaco.client.entity.WalletDetails;
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

    public AccountRegistrationResult RegisterAccount(String phoneNumber) {
        return null;
    }

    public AccountStatus GetAccountStatus() {
        return null;
    }

    public void ConfirmPhoneNumber(String validationCode) {

    }

    public Asset[] GetAssets() {
        HttpClient<Asset[]> client = getHttpClient();

        return client.DoGet("/assets", Asset[].class);
    }

    public Asset GetAsset(String ticker) {
        HttpClient<Asset> client = getHttpClient();

        return client.DoGet(String.format("/assets/%s", ticker), Asset.class);
    }

    public AssetsHistoryResult GetAssetsHistory(HistoryCriteria criteria) {
        HttpClient<AssetsHistoryResult> client = getHttpClient();

        return client.DoGet(String.format("/assets/history?from=%d&tp=%d&freq=%s&orderAsc=%s",
                criteria.getFrom(), criteria.getTo(), criteria.getFreq(), criteria.getOrderAsc()),
                AssetsHistoryResult.class);
    }

    public AssetsHistoryResult GetAssetHistory(String ticker, HistoryCriteria criteria) {
        HttpClient<AssetsHistoryResult> client = getHttpClient();

        return client.DoGet(String.format("/assets/%s/history?from=%d&tp=%d&freq=%s&orderAsc=%s",
                        ticker, criteria.getFrom(), criteria.getTo(), criteria.getFreq(), criteria.getOrderAsc()),
                AssetsHistoryResult.class);
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

    private <T> HttpClient<T> getHttpClient() {
        return new HttpClientImpl<T>(this.metacoApiId, this.metacoApiKey, this.metacoApiUrl, this.metacoTestingMode);
    }
}
