package com.metaco.api.contracts;

import com.google.gson.annotations.SerializedName;

public class PageCriteria {
    @SerializedName("pageNumber")
    private int pageNumber;
    @SerializedName("pageSize")
    private int pageSize;

    public PageCriteria() {
        pageSize = 500;
        pageNumber = 0;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
