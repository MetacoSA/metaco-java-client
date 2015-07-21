package com.metaco.client;

import com.metaco.client.entity.*;
import com.metaco.client.entity.NewOrder;
import com.metaco.client.entity.HistoryCriteria;
import com.metaco.client.entity.AccountRegistrationResult;
import com.metaco.client.entity.AssetsHistoryResult;
import com.metaco.client.entity.WalletDetails;

import java.util.List;

interface MetacoClient {

    AccountRegistrationResult RegisterAccount(String phoneNumber);

    AccountStatus GetAccountStatus();

    void ConfirmPhoneNumber(String validationCode);

    Asset[] GetAssets();

    Asset GetAsset(String ticker);

    AssetsHistoryResult GetAssetsHistory(HistoryCriteria criteria);

    AssetsHistoryResult GetAssetHistory(String ticker, HistoryCriteria criteria);

    Order CreateOrder(NewOrder createOrder);

    List<Order> GetOrders();

    Order GetOrder(String id);

    Order SubmitSignedOrder(String id, RawTransaction rawTransaction);

    void CancelOrder(String id);

    TransactionToSign CreateTransaction();

    void BroadcastTransaction(RawTransaction rawTransaction);

    WalletDetails GetWalletDetails();
}
