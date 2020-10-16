package org.ucbre.usecases.api;

public class BusinessUseCaseExecutorCreationFailedException extends RuntimeException{
    public BusinessUseCaseExecutorCreationFailedException(String message) {
        super(message);
    }

    public BusinessUseCaseExecutorCreationFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessUseCaseExecutorCreationFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
