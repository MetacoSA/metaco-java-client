package com.metaco.api.contracts;

import com.google.gson.annotations.SerializedName;

public class Issuer {
    @SerializedName("name")
    private String name;

    @SerializedName("address")
    private String address;

    @SerializedName("contact")
    private String contact;

    public Issuer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
