package com.metaco.api.contracts;

public class OrderResultPage {
    private PageDetails pageDetails;
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
