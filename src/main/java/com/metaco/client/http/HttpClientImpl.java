package com.metaco.client.http;

import com.google.gson.Gson;
import com.metaco.client.exceptions.ErrorHandler;
import com.metaco.client.exceptions.MetacoClientException;
import com.metaco.client.utils.HttpUtils;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;

public class HttpClientImpl<T> implements HttpClient<T> {

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

    public T DoPost(String url, Object data, Class<T> typeClass) throws MetacoClientException {
        Client client = Client.create();

        String jsonEntity = new Gson().toJson(data);

        WebResource webResource = client.resource(GetUrl(url));

        SetHeaders(webResource);

        ClientResponse response = webResource
                .entity(jsonEntity, MediaType.APPLICATION_JSON_TYPE)
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .post(ClientResponse.class);

        String json =  response.getEntity(String.class);

        if (!HttpUtils.IsSuccessStatusCode(response.getStatus())) {
            ErrorHandler.HandleInvalidResponse(response.getStatus(), json);
        }

        return new Gson().fromJson(json, typeClass);
    }

    public T DoGet(String url, Class<T> typeClass) throws MetacoClientException {
        Client client = Client.create();

        WebResource webResource = client.resource(GetUrl(url));

        SetHeaders(webResource);

        ClientResponse response = webResource
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);

        String json =  response.getEntity(String.class);

        if (!HttpUtils.IsSuccessStatusCode(response.getStatus())) {
            ErrorHandler.HandleInvalidResponse(response.getStatus(), json);
        }

        return new Gson().fromJson(json, typeClass);
    }

    public T DoPut(String url, Object data, Class<T> typeClass) throws MetacoClientException {
        Client client = Client.create();

        String jsonEntity = new Gson().toJson(data);

        WebResource webResource = client.resource(GetUrl(url));

        SetHeaders(webResource);

        ClientResponse response = webResource
                .entity(jsonEntity, MediaType.APPLICATION_JSON_TYPE)
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .put(ClientResponse.class);

        String json =  response.getEntity(String.class);

        if (!HttpUtils.IsSuccessStatusCode(response.getStatus())) {
            ErrorHandler.HandleInvalidResponse(response.getStatus(), json);
        }

        return new Gson().fromJson(json, typeClass);
    }

    public T DoDelete(String url, Object data, Class<T> typeClass) throws MetacoClientException {
        Client client = Client.create();

        String jsonEntity = new Gson().toJson(data);

        WebResource webResource = client.resource(GetUrl(url));

        SetHeaders(webResource);

        ClientResponse response = webResource
                .entity(jsonEntity, MediaType.APPLICATION_JSON_TYPE)
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .delete(ClientResponse.class);

        String json =  response.getEntity(String.class);

        if (!HttpUtils.IsSuccessStatusCode(response.getStatus())) {
            ErrorHandler.HandleInvalidResponse(response.getStatus(), json);
        }

        return new Gson().fromJson(json, typeClass);
    }

    private String GetUrl(String relativeUrl) {
        return this.metacoApiUrl + relativeUrl;
    }

    private void SetHeaders(WebResource resource) {
        if (this.metacoApiId != null && !this.metacoApiId.equals("") &&
                this.metacoApiKey != null && !this.metacoApiKey.equals("")) {
            resource.header("X-Metaco-Id", this.metacoApiId);
            resource.header("X-Metaco-Key", this.metacoApiKey);
        }

        if (this.metacoTestingMode != null && this.metacoTestingMode) {
            resource.header("X-Metaco-Testing-Mode", this.metacoApiKey);
        }
    }
}
