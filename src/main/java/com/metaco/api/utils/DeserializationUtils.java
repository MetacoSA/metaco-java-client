package com.metaco.api.utils;

import com.google.gson.Gson;
import com.sun.jersey.api.client.ClientResponse;

public class DeserializationUtils {
    private DeserializationUtils() {

    }

    public static <T> T ToObject(ClientResponse apiResponse, Class<T> typeClass) {
        String json = apiResponse.getEntity(String.class);
        return ToObject(json, typeClass);
    }

    static <T> T ToObject(String json, Class<T> typeClass) {
        try {
            return new Gson().fromJson(json, typeClass);
        } catch (Exception e) {
            return null;
        }
    }
}
