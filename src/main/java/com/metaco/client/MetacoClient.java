package com.metaco.client;

import com.metaco.client.contracts.*;
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
    AccountRegistrationResult registerAccount(RegisterAccountRequest request) throws MetacoClientException;

    /**
     * Requires Authentication
     * Return the details of an account (API Id, KYC Status and remaining trading amount)
     *
     * @return The account details
     * @throws MetacoClientException
     *
     * @see <a href="http://docs.metaco.apiary.io/#reference/account/account-management/get-account-status">Online Documentation</a>
     */
    AccountStatus getAccountStatus() throws MetacoClientException;

    /**
     * Requires Authentication
     * Validate the authenticated account, throws an exception if there is an error
     *
     * @throws MetacoClientException
     *
     * @see <a href="http://docs.metaco.apiary.io/#reference/account/confirm-a-registration/confirm-a-phone-number">Online Documentation</a>
     */
    void confirmPhoneNumber(ValidateAccountRequest request) throws MetacoClientException;

    /**
     * Returns all the available Assets and their details
     *
     * @return The assets array
     * @throws MetacoClientException
     *
     * @see <a href="http://docs.metaco.apiary.io/#reference/assets/assets-list/list-all-assets">Online Documentation</a>
     */
    Asset[] getAssets() throws MetacoClientException;

    /**
     * Returns the selected Asset if it exists and its details
     *
     * @return The asset object
     * @throws MetacoClientException
     *
     * @see <a href="http://docs.metaco.apiary.io/#reference/assets/asset-information/retrieve-an-asset">Online Documentation</a>
     */
    Asset getAsset(String ticker) throws MetacoClientException;

    /**
     * Returns the history for all the available assets according to the given criteria
     *
     * @return The history object
     * @throws MetacoClientException
     *
     * @see <a href="http://docs.metaco.apiary.io/#reference/assets/asset-information/retrieve-an-asset">Online Documentation</a>
     */
    AssetsHistoryResult getAssetsHistory(HistoryCriteria criteria) throws MetacoClientException;

    /**
     * Returns the history for the provided assets according to the given criteria
     * Assets must be given using this format : USD,XAU,etc..
     *
     * @return The history object
     * @throws MetacoClientException
     *
     * @see <a href="http://docs.metaco.apiary.io/#reference/assets/asset-information/retrieve-an-asset">Online Documentation</a>
     */
    AssetsHistoryResult getAssetsHistory(HistoryCriteria criteria, List<String> tickers) throws MetacoClientException;

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
    Order createOrder(NewOrder createOrder) throws MetacoClientException;

    /**
     * Requires Authentication
     * Returns the user's orders
     *
     * @return The orders array
     * @throws MetacoClientException
     *
     * @see <a href="http://docs.metaco.apiary.io/#reference/orders/orders-management/list-all-orders">Online Documentation</a>
     */
    Order[] getOrders() throws MetacoClientException;

    /**
     * Requires Authentication
     * Returns the specified user's order
     *
     * @return The order object
     * @throws MetacoClientException
     *
     * @see <a href="http://docs.metaco.apiary.io/#reference/orders/order-information/retreive-an-order">Online Documentation</a>
     */
    Order getOrder(String id) throws MetacoClientException;

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
    Order submitSignedOrder(String id, RawTransaction rawTransaction) throws MetacoClientException;

    /**
     * Requires Authentication
     * Cancel the specified order
     *
     * @throws MetacoClientException
     *
     * @see <a href="http://docs.metaco.apiary.io/#reference/orders/order-information/cancel-an-order">Online Documentation</a>
     */
    void cancelOrder(String id) throws MetacoClientException;

    /**
     * Requires Authentication
     * Create a Transaction using the provided parameters
     *
     * @throws MetacoClientException
     *
     * @see <a href="http://docs.metaco.apiary.io/#reference/transactions/raw-transaction/get-a-raw-transaction">Online Documentation</a>
     */
    TransactionToSign createTransaction(NewTransaction newTransaction) throws MetacoClientException;

    /**
     * Requires Authentication
     * Submit a signed transaction
     * You have to sign each of your inputs of the selected transaction (you will get those details when creating the transaction through Metaco)
     * Then encode the transaction in hexadecimal and send it here
     *
     * @throws MetacoClientException
     *
     * @see <a href="http://docs.metaco.apiary.io/#reference/transactions/transaction-broadcast/broadcast-a-transaction">Online Documentation</a>
     */
    TransactionBroadcastResult broadcastTransaction(RawTransaction rawTransaction) throws MetacoClientException;

    /**
     * Requires Authentication
     * Returns the current wallet state
     * Contains the current balances, the values and the transaction history
     *
     * @throws MetacoClientException
     *
     * @see <a href="http://docs.metaco.apiary.io/#reference/transactions/transaction-broadcast/fetch-wallet-information">Online Documentation</a>
     */
    WalletDetails getWalletDetails(List<String> addresses) throws MetacoClientException;
}
