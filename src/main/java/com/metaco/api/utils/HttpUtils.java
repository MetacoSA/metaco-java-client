package com.metaco.api.utils;

public class HttpUtils {
    private HttpUtils() {

    }

    public static Boolean IsSuccessStatusCode(int status) {
        String code = String.valueOf(status);

        return code.matches("^2[0-9]{2}");
    }
}
