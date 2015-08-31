package com.metaco.api;

import com.metaco.api.contracts.*;
import com.metaco.api.exceptions.MetacoClientException;

import java.util.List;

public interface MetacoClient {

    /**
     * Register an account on Metaco
     * Sends an SMS to the provided phone number
     *
     * If you are a wallet registering accounts for your clients, don't forget to set the provider_id with your Name/ID.
     *
     * If you are in debug mode, this request will return a HTTP header X-Metaco-DebugData with the validation code, it won't be send by SMS
     *
     * @return The initial account settings
     * @throws MetacoClientException
     * @see <a href="http://docs.metaco.apiary.io/#reference/account/account-management/register-an-account">Online Documentation</a>
     */
    AccountRegistrationResult registerAccount(RegisterAccountRequest request) throws MetacoClientException;

    /**
     * Requires Authentication
     * Return the details of an account (API Id, KYC Status and remaining trading amount)
     *
     * @return The account details
     * @throws MetacoClientException
     * @see <a href="http://docs.metaco.apiary.io/#reference/account/account-management/get-account-status">Online Documentation</a>
     */
    AccountStatus getAccountStatus() throws MetacoClientException;

    /**
     * Requires Authentication
     * Validate the authenticated account, throws an exception if there is an error
     *
     * @throws MetacoClientException
     * @see <a href="http://docs.metaco.apiary.io/#reference/account/confirm-a-registration/confirm-a-phone-number">Online Documentation</a>
     */
    void confirmPhoneNumber(ValidateAccountRequest request) throws MetacoClientException;

    /**
     * Returns all the available Assets and their details
     *
     * @return The assets array
     * @throws MetacoClientException
     * @see <a href="http://docs.metaco.apiary.io/#reference/assets/assets-list/list-all-assets">Online Documentation</a>
     */
    Asset[] getAssets() throws MetacoClientException;

    /**
     * Returns the selected Asset if it exists and its details
     *
     * @return The asset object
     * @throws MetacoClientException
     * @see <a href="http://docs.metaco.apiary.io/#reference/assets/asset-information/retrieve-an-asset">Online Documentation</a>
     */
    Asset getAsset(String ticker) throws MetacoClientException;

    /**
     * Returns the history for all the available assets according to the given criteria
     *
     * @return The history object
     * @throws MetacoClientException
     * @see <a href="http://docs.metaco.apiary.io/#reference/assets/assets-history/retrieve-history-of-all-assets">Online Documentation</a>
     */
    AssetsHistoryResult getAssetsHistory(HistoryCriteria criteria) throws MetacoClientException;

    /**
     * Returns the history for the provided assets according to the given criteria
     * Assets must be given using this format : USD,XAU,etc..
     *
     * @return The history object
     * @throws MetacoClientException
     * @see <a href="http://docs.metaco.apiary.io/#reference/assets/assets-history/retrieve-history-of-all-assets">Online Documentation</a>
     */
    AssetsHistoryResult getAssetsHistory(HistoryCriteria criteria, List<String> tickers) throws MetacoClientException;

    /**
     * Requires Authentication
     * Create an order using the provided parameters
     * This order will be processed in our system
     * It will require your signature later when the trade state will be Signing
     *
     * @throws MetacoClientException
     * @see <a href="http://docs.metaco.apiary.io/#reference/orders/orders-management/request-an-order">Online Documentation</a>
     */
    Order createOrder(NewOrder createOrder) throws MetacoClientException;

    /**
     * Requires Authentication
     * Returns the user's orders, you will get the 500 first results
     *
     * @return The orders array
     * @throws MetacoClientException
     * @see <a href="http://docs.metaco.apiary.io/#reference/orders/orders-management/list-all-orders">Online Documentation</a>
     */
    OrderResultPage getOrders() throws MetacoClientException;

    /**
     * Requires Authentication
     * Returns the user's orders, according to the pageCriteria settings (the page size is limited to 500)
     *
     * @return The orders array
     * @throws MetacoClientException
     * @see <a href="http://docs.metaco.apiary.io/#reference/orders/orders-management/list-all-orders">Online Documentation</a>
     */
    OrderResultPage getOrders(PageCriteria pageCriteria) throws MetacoClientException;

    /**
     * Requires Authentication
     * Returns the specified user's order
     *
     * @return The order object
     * @throws MetacoClientException
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
     * @see <a href="http://docs.metaco.apiary.io/#reference/orders/order-information/submit-a-signed-order">Online Documentation</a>
     */
    Order submitSignedOrder(String id, RawTransaction rawTransaction) throws MetacoClientException;

    /**
     * Requires Authentication
     * Cancel the specified order
     *
     * @throws MetacoClientException
     * @see <a href="http://docs.metaco.apiary.io/#reference/orders/order-information/cancel-an-order">Online Documentation</a>
     */
    void cancelOrder(String id) throws MetacoClientException;

    /**
     * Requires Authentication
     * Create a Transaction using the provided parameters
     *
     * @throws MetacoClientException
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
     * @see <a href="http://docs.metaco.apiary.io/#reference/transactions/transaction-broadcast/broadcast-a-transaction">Online Documentation</a>
     */
    TransactionBroadcastResult broadcastTransaction(RawTransaction rawTransaction) throws MetacoClientException;

    /**
     * Requires Authentication
     * Returns the current wallet state
     * The transaction history is paginated, you will get the 500 first results
     * Contains the current balances, the values and the transaction history
     *
     * @throws MetacoClientException
     * @see <a href="http://docs.metaco.apiary.io/#reference/transactions/transaction-broadcast/fetch-wallet-information">Online Documentation</a>
     */
    WalletDetails getWalletDetails(String address) throws MetacoClientException;

    /**
     * Requires Authentication
     * Returns the current wallet state
     * The transaction history is paginated, you can choose your page using the pageCriteria parameter (the page size is limited to 500)
     * Contains the current balances, the values and the transaction history
     *
     * @throws MetacoClientException
     * @see <a href="http://docs.metaco.apiary.io/#reference/transactions/transaction-broadcast/fetch-wallet-information">Online Documentation</a>
     */
    WalletDetails getWalletDetails(String address, PageCriteria pageCriteria) throws MetacoClientException;

    /**
     * For testing purposes only
     * On some requests, when you use the TestingMode of the client, you will get a DebugData, which will simplify the testing of the API and the client
     * As an example, a debugData could be the fake validationCode when your register an account.
     */
    String getLatestDebugData();
}
