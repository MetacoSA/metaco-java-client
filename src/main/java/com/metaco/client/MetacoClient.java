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

    /**
     * Requires Authentication
     * Create an order using the provided parameters
     * This order will be processed in our system
     * It will require your signature later when the trade state will be Signing
     *
     * @throws MetacoClientException
     *
     * @see <a href="http://docs.metaco.apiary.io/#reference/orders/orders-management/request-an-order">Online Documentation</a>
     */
    Order CreateOrder(NewOrder createOrder) throws MetacoClientException;

    /**
     * Requires Authentication
     * Returns the user's orders
     *
     * @return The orders array
     * @throws MetacoClientException
     *
     * @see <a href="http://docs.metaco.apiary.io/#reference/orders/orders-management/list-all-orders">Online Documentation</a>
     */
    Order[] GetOrders() throws MetacoClientException;

    /**
     * Requires Authentication
     * Returns the specified user's order
     *
     * @return The order object
     * @throws MetacoClientException
     *
     * @see <a href="http://docs.metaco.apiary.io/#reference/orders/order-information/retreive-an-order">Online Documentation</a>
     */
    Order GetOrder(String id) throws MetacoClientException;

    /**
     * Requires Authentication
     * Submit a signed order
     * You have to sign each of your inputs of the selected order (you will get those details by fetching the orders)
     * Then encode the transaction in hexadecimal and send it here
     *
     * @throws MetacoClientException
     *
     * @see <a href="http://docs.metaco.apiary.io/#reference/orders/order-information/submit-a-signed-order">Online Documentation</a>
     */
    Order SubmitSignedOrder(String id, RawTransaction rawTransaction) throws MetacoClientException;

    /**
     * Requires Authentication
     * Cancel the specified order
     *
     * @throws MetacoClientException
     *
     * @see <a href="http://docs.metaco.apiary.io/#reference/orders/order-information/cancel-an-order">Online Documentation</a>
     */
    void CancelOrder(String id) throws MetacoClientException;

    TransactionToSign CreateTransaction() throws MetacoClientException;

    //TODO
    void BroadcastTransaction(RawTransaction rawTransaction) throws MetacoClientException;

    WalletDetails GetWalletDetails() throws MetacoClientException;
}
