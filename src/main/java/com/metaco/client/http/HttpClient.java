package com.metaco.client.http;

public interface HttpClient<E> {
    E DoPost(String uri, Object data, Class<E> typeClass);
    E DoGet(String uri, Class<E> typeClass);
    E DoPut(String uri, Object data, Class<E> typeClass);
    E DoDelete(String uri, Object data, Class<E> typeClass);
}
