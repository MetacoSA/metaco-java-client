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

    /**
     * Register an account on Metaco
     *
     * Sends an SMS to the provided phone number
     *
     * @return The initial account settings
     * @throws MetacoClientException
     *
     * @see <a href="http://docs.metaco.apiary.io/#reference/account/account-management/register-an-account">Online Documentation</a>
     */
    AccountRegistrationResult RegisterAccount(RegisterAccountRequest request) throws MetacoClientException;

    /**
     * Requires Authentication
     * Return the details of an account (API Id, KYC Status and remaining trading amount)
     *
     * @return The account details
     * @throws MetacoClientException
     *
     * @see <a href="http://docs.metaco.apiary.io/#reference/account/account-management/get-account-status">Online Documentation</a>
     */
    AccountStatus GetAccountStatus() throws MetacoClientException;

    /**
     * Requires Authentication
     * Validate the authenticated account, throws an exception if there is an error
     *
     * @throws MetacoClientException
     *
     * @see <a href="http://docs.metaco.apiary.io/#reference/account/confirm-a-registration/confirm-a-phone-number">Online Documentation</a>
     */
    void ConfirmPhoneNumber(ValidateAccountRequest request) throws MetacoClientException;

    /**
     * Returns all the available Assets and their details
     *
     * @return The assets array
     * @throws MetacoClientException
     *
     * @see <a href="http://docs.metaco.apiary.io/#reference/assets/assets-list/list-all-assets">Online Documentation</a>
     */
    Asset[] GetAssets() throws MetacoClientException;

    /**
     * Returns the selected Asset if it exists and its details
     *
     * @return The asset object
     * @throws MetacoClientException
     *
     * @see <a href="http://docs.metaco.apiary.io/#reference/assets/asset-information/retrieve-an-asset">Online Documentation</a>
     */
    Asset GetAsset(String ticker) throws MetacoClientException;

    /**
     * Returns the history for all the available assets according to the given criteria
     *
     * @return The history object
     * @throws MetacoClientException
     *
     * @see <a href="http://docs.metaco.apiary.io/#reference/assets/asset-information/retrieve-an-asset">Online Documentation</a>
     */
    AssetsHistoryResult GetAssetsHistory(HistoryCriteria criteria) throws MetacoClientException;

    /**
     * Returns the history for the provided assets according to the given criteria
     * Assets must be given using this format : USD,XAU,etc..
     *
     * @return The history object
     * @throws MetacoClientException
     *
     * @see <a href="http://docs.metaco.apiary.io/#reference/assets/asset-information/retrieve-an-asset">Online Documentation</a>
     */
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
