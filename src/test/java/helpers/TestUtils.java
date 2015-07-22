package helpers;

import com.metaco.api.MetacoClientBuilder;

import java.util.Map;

public class TestUtils {
    private static String DEFAULT_API_URL = "http://api.testnet.metaco.com/v1/";
    private static String DEFAULT_API_ID = null;
    private static String DEFAULT_API_KEY = null;

    public static MetacoClientBuilder GetMetacoAnonymousClientTestBuilder() {
        Map<String, String> env = System.getenv();

        String apiUrl = env.containsKey("DEFAULT_API_URL") ? env.get("DEFAULT_API_URL") : DEFAULT_API_URL;

        return new MetacoClientBuilder()
                .withApiUrl(apiUrl)
                .withTestingMode(true);
    }

    public static MetacoClientBuilder GetMetacoAuthenticatedClientTestBuilder() {
        Map<String, String> env = System.getenv();

        String apiUrl = env.containsKey("DEFAULT_API_URL") ? env.get("DEFAULT_API_URL") : DEFAULT_API_URL;
        String apiId = env.containsKey("DEFAULT_API_ID") ? env.get("DEFAULT_API_ID") : DEFAULT_API_ID;
        String apiKey = env.containsKey("DEFAULT_API_KEY") ? env.get("DEFAULT_API_KEY") : DEFAULT_API_KEY;

        return new MetacoClientBuilder()
                .withApiUrl(apiUrl)
                .withApiId(apiId)
                .withApiKey(apiKey)
                .withTestingMode(true);
    }
}
