package com.metaco.api.http;

import com.metaco.api.exceptions.MetacoClientException;
import com.sun.jersey.api.client.ClientResponse;

public interface HttpClient {
    ClientResponse doPost(String uri, Object data) throws MetacoClientException;

    ClientResponse doGet(String uri) throws MetacoClientException;

    ClientResponse doDelete(String uri) throws MetacoClientException;
}
