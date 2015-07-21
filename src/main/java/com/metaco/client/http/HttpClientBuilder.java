package com.metaco.client.http;

public class HttpClientBuilder {

    protected String metacoApiId;
    protected String metacoApiKey;
    protected String metacoApiUrl;
    protected Boolean testingMode;

    public HttpClient makeClient() {
        return new HttpClientImpl(this);
    }

    public HttpClientBuilder withApiId(String apiId) {
        this.metacoApiId = apiId;
        return this;
    }

    public HttpClientBuilder withApiKey(String apiKey) {
        this.metacoApiId = apiKey;
        return this;
    }

    public HttpClientBuilder withApiUrl(String apiUrl) {
        this.metacoApiId = apiUrl;
        return this;
    }

    public HttpClientBuilder withTestingMode(Boolean testingMode) {
        this.testingMode = testingMode;
        return this;
    }
}
