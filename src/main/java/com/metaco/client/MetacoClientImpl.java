package com.metaco.client;

import com.metaco.client.entity.*;
import com.metaco.client.entity.NewOrder;
import com.metaco.client.entity.HistoryCriteria;
import com.metaco.client.entity.AccountRegistrationResult;
import com.metaco.client.entity.AssetsHistoryResult;
import com.metaco.client.entity.WalletDetails;
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

    public AccountRegistrationResult RegisterAccount(String phoneNumber) {
        return null;
    }

    public AccountStatus GetAccountStatus() throws MetacoClientException {
        HttpClient<AccountStatus> client = getHttpClient();

        return client.DoGet("/account", AccountStatus.class);
    }

    public void ConfirmPhoneNumber(String validationCode) throws MetacoClientException  {

    }

    public Asset[] GetAssets() throws MetacoClientException  {
        HttpClient<Asset[]> client = getHttpClient();

        return client.DoGet("/assets", Asset[].class);
    }

    public Asset GetAsset(String ticker) throws MetacoClientException {
        HttpClient<Asset> client = getHttpClient();

        return client.DoGet(String.format("/assets/%s", ticker), Asset.class);
    }


    public AssetsHistoryResult GetAssetsHistory(HistoryCriteria criteria) throws MetacoClientException  {
        return GetAssetsHistory(criteria, null);
    }

    public AssetsHistoryResult GetAssetsHistory(HistoryCriteria criteria, List<String> tickers) throws MetacoClientException  {
        HttpClient<AssetsHistoryResult> client = getHttpClient();

        String tickersStr = (tickers == null || tickers.isEmpty()) ? "all" : String.join(",", tickers);

        return client.DoGet(String.format("/assets/history?tickers=%s&from=%d&to=%d&freq=%s&orderAsc=%s",
                tickersStr, criteria.getFrom(), criteria.getTo(), criteria.getFreq(), criteria.getOrderAsc()),
                AssetsHistoryResult.class);
    }

    public Order CreateOrder(NewOrder createOrder) throws MetacoClientException  {
        return null;
    }

    public List<Order> GetOrders() throws MetacoClientException  {
        return null;
    }

    public Order GetOrder(String id) throws MetacoClientException  {
        return null;
    }

    public Order SubmitSignedOrder(String id, RawTransaction rawTransaction) throws MetacoClientException  {
        return null;
    }

    public void CancelOrder(String id) throws MetacoClientException  {

    }

    public TransactionToSign CreateTransaction() throws MetacoClientException {
        return null;
    }

    public void BroadcastTransaction(RawTransaction rawTransaction) throws MetacoClientException {

    }

    public WalletDetails GetWalletDetails() throws MetacoClientException {
        return null;
    }

    private <T> HttpClient<T> getHttpClient() {
        return new HttpClientImpl<T>(this.metacoApiId, this.metacoApiKey, this.metacoApiUrl, this.metacoTestingMode);
    }
}
