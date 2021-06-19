package com.mycompany.springapp.productapp.exception;

public class BusinessException extends Exception {
    private String errorCode;
    private String errorMessage;

    public BusinessException()
    {
        super();
    }

    public BusinessException(String errorCode, String errorMessage)
    {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
