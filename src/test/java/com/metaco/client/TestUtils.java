package com.metaco.client;

import java.util.Map;

public class TestUtils {
    private static String DEFAULT_API_URL = "http://api.testnet.metaco.com/v1/";

    public static MetacoClientBuilder GetMetacoClientTestBuilder() {
        Map<String, String> env = System.getenv();

        String apiUrl = env.containsKey("DEFAULT_API_URL") ? env.get("DEFAULT_API_URL") : DEFAULT_API_URL;

        return new MetacoClientBuilder()
                .withApiUrl(apiUrl)
                .withTestingMode(true);
    }
}
