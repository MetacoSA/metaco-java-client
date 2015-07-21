package com.metaco.client.exceptions;

public class MetacoClientException extends Exception {
    private String content;
    private int statusCode;
    private MetacoErrorResult metacoError;
    private MetacoErrorsDefinitions.ErrorType errorType;

    public MetacoClientException(MetacoErrorResult errorResult, MetacoErrorsDefinitions.ErrorType errorType, String content, int statusCode) {
        this.metacoError = errorResult;
        this.errorType = errorType;
        this.content = content;
        this.statusCode = statusCode;
    }

    public MetacoErrorResult getMetacoError() {
        return metacoError;
    }

    public MetacoErrorsDefinitions.ErrorType getErrorType() {
        return errorType;
    }

    public String getContent() {
        return content;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
