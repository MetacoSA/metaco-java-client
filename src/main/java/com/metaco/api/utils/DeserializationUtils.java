package com.metaco.api.utils;

import com.google.gson.Gson;
import com.sun.jersey.api.client.ClientResponse;

public class DeserializationUtils {

    public static <T> T ToObject(ClientResponse apiResponse, Class<T> typeClass) {
        try {
            String json =  apiResponse.getEntity(String.class);
            return new Gson().fromJson(json, typeClass);
        } catch (Exception e) {
            return null;
        }
    }
}
