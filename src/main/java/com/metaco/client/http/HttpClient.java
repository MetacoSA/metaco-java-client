package com.metaco.client.http;

import com.metaco.client.exceptions.MetacoClientException;

public interface HttpClient<E> {
    E DoPost(String uri, Object data, Class<E> typeClass) throws MetacoClientException;
    E DoGet(String uri, Class<E> typeClass) throws MetacoClientException;
    E DoPut(String uri, Object data, Class<E> typeClass) throws MetacoClientException;
    E DoDelete(String uri, Object data, Class<E> typeClass) throws MetacoClientException;
}
