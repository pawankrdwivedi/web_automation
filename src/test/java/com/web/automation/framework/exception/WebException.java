package com.web.automation.framework.exception;

public class WebException extends RuntimeException {
    private static final long serialVersionUID = 539938974032006775L;


    public WebException(String message) {
        super(message);
    }

    public WebException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public WebException(Throwable throwable) {
        super(throwable);
    }


}
