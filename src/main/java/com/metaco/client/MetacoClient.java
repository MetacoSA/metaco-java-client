package com.metaco.client;

import com.metaco.client.contracts.*;
import com.metaco.client.contracts.NewOrder;
import com.metaco.client.contracts.HistoryCriteria;
import com.metaco.client.contracts.AccountRegistrationResult;
import com.metaco.client.contracts.AssetsHistoryResult;
import com.metaco.client.contracts.WalletDetails;
import com.metaco.client.exceptions.MetacoClientException;

import java.util.List;

interface MetacoClient {

    AccountRegistrationResult RegisterAccount(RegisterAccountRequest request) throws MetacoClientException;

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
