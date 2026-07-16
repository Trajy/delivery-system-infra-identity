package br.com.trajy.delivery.infra.identity.core.common.exception;

public class UnsupportedInstantiationException extends RuntimeException {

    public UnsupportedInstantiationException(String message) {
        super(message);
    }

    public static UnsupportedInstantiationException utilityClassUnsupportedInstantiationException() {
        throw new UnsupportedInstantiationException("Utility class cannot be instantiated.");
    }

}
