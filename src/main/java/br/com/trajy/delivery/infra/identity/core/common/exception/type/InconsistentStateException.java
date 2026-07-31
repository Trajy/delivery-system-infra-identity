package br.com.trajy.delivery.infra.identity.core.common.exception.type;

import static java.lang.System.lineSeparator;

public class InconsistentStateException extends RuntimeException {

    private InconsistentStateException(InconsistentStateExceptionBuilder builder) {
        super(builder.sb.toString());
    }

    public static InconsistentStateExceptionBuilder builder() {
        return new InconsistentStateExceptionBuilder();
    }

    public static class InconsistentStateExceptionBuilder {

        private final StringBuilder sb = new StringBuilder();

        public InconsistentStateExceptionBuilder appendMessage(String message) {
            if(!sb.isEmpty()) {
                sb.append(lineSeparator());
            }
            sb.append(message);
            return this;
        }

        public void throwIfHasMessage() {
            if(!sb.isEmpty()) {
                throw new InconsistentStateException(this);
            }
        }

    }

}
