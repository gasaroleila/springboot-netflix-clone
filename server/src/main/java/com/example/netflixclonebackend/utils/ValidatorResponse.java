package com.example.netflixclonebackend.utils;

public class ValidatorResponse {
    private String message;
    private Boolean validation;

    public ValidatorResponse() {
    }

    public ValidatorResponse(String message, Boolean validation) {
        this.message = message;
        this.validation = validation;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getValidation() {
        return validation;
    }

    public void setValidation(Boolean validation) {
        this.validation = validation;
    }
}
