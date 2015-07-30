package com.metaco.api.exceptions;

import com.google.gson.Gson;
import com.metaco.api.utils.HttpUtils;
import com.sun.jersey.api.client.ClientResponse;

public class ErrorHandler {

    private ErrorHandler() {}

    public static void HandleInvalidResponse(ClientResponse response) throws MetacoClientException {
        if (!HttpUtils.IsSuccessStatusCode(response.getStatus())) {
            MetacoErrorResult metacoError;
            String json = "";
            try {
                json = response.getEntity(String.class);
                metacoError = new Gson().fromJson(json, MetacoErrorResult.class);
                if (metacoError.getMetaco_error().equals("")) throw new Exception();
            } catch (Exception e) {
                metacoError = new MetacoErrorResult();
                metacoError.setMetaco_error("");
                metacoError.setStatus(response.getStatus());
            }

            MetacoErrorsDefinitions.ErrorType errorType = MetacoErrorsDefinitions.GetErrorType(metacoError);
            throw new MetacoClientException(metacoError, errorType, json, response.getStatus());
        }
    }
}
