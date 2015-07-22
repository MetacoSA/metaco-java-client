package com.metaco.client.exceptions;

import com.google.gson.Gson;

public class ErrorHandler {
    public static void HandleInvalidResponse(int statusCode, String content) throws MetacoClientException {
        MetacoErrorResult metacoError;
        try {
            metacoError = new Gson().fromJson(content, MetacoErrorResult.class);
            if (metacoError.getMetaco_error().equals("")) throw new Exception();
        } catch (Exception e) {
            metacoError = new MetacoErrorResult();
            metacoError.setMetaco_error("");
            metacoError.setStatus(statusCode);
        }

        ThrowError(metacoError, content, statusCode);
    }

    private static void ThrowError(MetacoErrorResult metacoError, String content, int statusCode) throws MetacoClientException {
        MetacoErrorsDefinitions.ErrorType errorType = MetacoErrorsDefinitions.GetErrorType(metacoError);
        throw new MetacoClientException(null, errorType, content, statusCode);
    }
}
