package com.metaco.api.http;

import com.google.gson.Gson;
import com.metaco.api.exceptions.ErrorHandler;
import com.metaco.api.exceptions.MetacoClientException;
import com.metaco.api.utils.HttpUtils;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;

public class HttpClientImpl implements HttpClient {

    private String metacoApiId;
    private String metacoApiKey;
    private String metacoApiUrl;
    private Boolean metacoTestingMode;

    public HttpClientImpl(String metacoApiId, String metacoApiKey, String metacoApiUrl, Boolean metacoTestingMode) {
        this.metacoApiId = metacoApiId;
        this.metacoApiKey = metacoApiKey;
        this.metacoApiUrl = metacoApiUrl;
        this.metacoTestingMode = metacoTestingMode;
    }

    public ClientResponse doPost(String url, Object data) throws MetacoClientException {
        Client client = Client.create();

        String jsonEntity = new Gson().toJson(data);

        WebResource webResource = client.resource(GetUrl(url));

        WebResource.Builder builder = SetHeaders(webResource);

        ClientResponse response = builder
                .entity(jsonEntity, MediaType.APPLICATION_JSON_TYPE)
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .post(ClientResponse.class);

        HandleErrorIfNeeded(response);

        return response;
    }

    public ClientResponse doGet(String url) throws MetacoClientException {
        Client client = Client.create();

        WebResource webResource = client.resource(GetUrl(url));

        WebResource.Builder builder = SetHeaders(webResource);

        ClientResponse response = builder
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);

        HandleErrorIfNeeded(response);

        return response;
    }

    public ClientResponse doDelete(String url) throws MetacoClientException {

        Client client = Client.create();

        WebResource webResource = client.resource(GetUrl(url));

        WebResource.Builder builder = SetHeaders(webResource);

        ClientResponse response = builder
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .delete(ClientResponse.class);

        HandleErrorIfNeeded(response);

        return response;
    }

    private String GetUrl(String relativeUrl) {
        return this.metacoApiUrl + relativeUrl;
    }

    private WebResource.Builder SetHeaders(WebResource resource) {
        WebResource.Builder builder = resource.getRequestBuilder();

        if (this.metacoApiId != null && !this.metacoApiId.equals("") &&
                this.metacoApiKey != null && !this.metacoApiKey.equals("")) {
            builder.header("X-Metaco-Id", this.metacoApiId)
                    .header("X-Metaco-Key", this.metacoApiKey);
        }

        if (this.metacoTestingMode != null && this.metacoTestingMode) {
            builder.header("X-Metaco-Debug", true);
        }

        return builder;
    }

    private void HandleErrorIfNeeded(ClientResponse response) throws MetacoClientException {
        ErrorHandler.HandleInvalidResponse(response);
    }
}
