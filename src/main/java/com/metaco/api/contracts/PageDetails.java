package com.metaco.api.contracts;

import com.google.gson.annotations.SerializedName;

public class PageDetails {
    @SerializedName("number")
    private int number;
    @SerializedName("size")
    private int size;

    public PageDetails() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
