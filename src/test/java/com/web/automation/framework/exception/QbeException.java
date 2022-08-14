package com.web.automation.framework.exception;

public class QbeException extends RuntimeException {
    private static final long serialVersionUID = 539938974032006775L;


    public QbeException(String message) {
        super(message);
    }

    public QbeException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public QbeException(Throwable throwable) {
        super(throwable);
    }


}
