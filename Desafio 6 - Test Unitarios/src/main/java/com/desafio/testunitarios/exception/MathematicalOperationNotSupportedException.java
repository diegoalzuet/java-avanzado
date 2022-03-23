package com.desafio.testunitarios.exception;

public class MathematicalOperationNotSupportedException extends Throwable {
    public MathematicalOperationNotSupportedException(String message) {
        super(message);
    }
}
