package com.metaco.api.http;

import com.metaco.api.exceptions.MetacoClientException;

public interface HttpClient<E> {
    void doPost(String uri, Object data) throws MetacoClientException;
    E doPost(String uri, Object data, Class<E> typeClass) throws MetacoClientException;
    E doGet(String uri, Class<E> typeClass) throws MetacoClientException;
    E doPut(String uri, Object data, Class<E> typeClass) throws MetacoClientException;
    void doDelete(String uri) throws MetacoClientException;
    E doDelete(String uri, Class<E> typeClass) throws MetacoClientException;
}
