package com.metaco.client;

import com.metaco.client.entity.*;
import com.metaco.client.entity.NewOrder;
import com.metaco.client.entity.HistoryCriteria;
import com.metaco.client.entity.AccountRegistrationResult;
import com.metaco.client.entity.AssetsHistoryResult;
import com.metaco.client.entity.WalletDetails;
import com.metaco.client.exceptions.MetacoClientException;

import java.util.List;

interface MetacoClient {

    AccountRegistrationResult RegisterAccount(String phoneNumber);

    AccountStatus GetAccountStatus() throws MetacoClientException;

    void ConfirmPhoneNumber(String validationCode) throws MetacoClientException;

    Asset[] GetAssets() throws MetacoClientException;

    Asset GetAsset(String ticker) throws MetacoClientException;

    AssetsHistoryResult GetAssetsHistory(HistoryCriteria criteria) throws MetacoClientException;
    AssetsHistoryResult GetAssetsHistory(HistoryCriteria criteria, List<String> tickers) throws MetacoClientException;

    Order CreateOrder(NewOrder createOrder) throws MetacoClientException;

    List<Order> GetOrders() throws MetacoClientException;

    Order GetOrder(String id) throws MetacoClientException;

    Order SubmitSignedOrder(String id, RawTransaction rawTransaction) throws MetacoClientException;

    void CancelOrder(String id) throws MetacoClientException;

    TransactionToSign CreateTransaction() throws MetacoClientException;

    void BroadcastTransaction(RawTransaction rawTransaction) throws MetacoClientException;

    WalletDetails GetWalletDetails() throws MetacoClientException;
}
