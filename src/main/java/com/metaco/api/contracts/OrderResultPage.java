package com.metaco.api.contracts;

import com.google.gson.annotations.SerializedName;

public class OrderResultPage {
    @SerializedName("page")
    private PageDetails pageDetails;
    @SerializedName("orders")
    private Order[] orders;

    public OrderResultPage() {
    }

    public PageDetails getPageDetails() {
        return pageDetails;
    }

    public void setPageDetails(PageDetails pageDetails) {
        this.pageDetails = pageDetails;
    }

    public Order[] getOrders() {
        return orders;
    }

    public void setOrders(Order[] orders) {
        this.orders = orders;
    }
}
