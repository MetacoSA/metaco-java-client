package com.metaco.api.contracts;

public class PageDetails {
    private int number;
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
