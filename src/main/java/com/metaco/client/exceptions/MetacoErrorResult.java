package com.metaco.client.exceptions;

public class MetacoErrorResult {
    private int status;
    private String metaco_error;
    private String location;
    private String parameter_name;
    private String message;

    public MetacoErrorResult() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMetaco_error() {
        return metaco_error;
    }

    public void setMetaco_error(String metaco_error) {
        this.metaco_error = metaco_error;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getParameter_name() {
        return parameter_name;
    }

    public void setParameter_name(String parameter_name) {
        this.parameter_name = parameter_name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
