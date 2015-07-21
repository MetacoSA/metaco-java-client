package com.metaco.client.http;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

class HttpClientImpl<E> implements HttpClient<E> {

    HttpClientImpl(HttpClientBuilder builder) {

    }

    public E DoPost(String uri, Object data, Class<E> typeClass) {
        return null;
    }

    public E DoGet(String uri, Class<E> typeClass) {
        try {
            Client client = Client.create();
            WebResource webResource = client.resource("http://***REMOVED***/v1/assets");
            ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }

            String output = response.getEntity(String.class);
            return new Gson().fromJson(output, typeClass);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public E DoPut(String uri, Object data, Class<E> typeClass) {
        return null;
    }

    public E DoDelete(String uri, Object data, Class<E> typeClass) {
        return null;
    }
}
