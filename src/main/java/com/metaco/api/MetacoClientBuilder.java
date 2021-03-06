package com.metaco.api;

public class MetacoClientBuilder {

    protected String metacoApiId;
    protected String metacoApiKey;
    protected String metacoApiUrl;
    protected Boolean metacoTestingMode;

    public MetacoClient makeClient() {
        return new MetacoClientImpl(this);
    }

    public MetacoClientBuilder withApiId(String apiId) {
        this.metacoApiId = apiId;
        return this;
    }

    public MetacoClientBuilder withApiKey(String apiKey) {
        this.metacoApiKey = apiKey;
        return this;
    }

    public MetacoClientBuilder withApiUrl(String apiUrl) {
        this.metacoApiUrl = apiUrl;
        return this;
    }

    public MetacoClientBuilder withTestingMode(Boolean testingMode) {
        this.metacoTestingMode = testingMode;
        return this;
    }
}
