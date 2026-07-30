package br.com.trajy.delivery.infra.identity.core.common.exception.model;

public class Error {

    private final String description;

    private Error(ErrorBuilder builder) {
        this.description = builder.description;
    }

    public String getDescription() {
        return description;
    }

    public static ErrorBuilder builder() {
        return new ErrorBuilder();
    }

    public static class ErrorBuilder {

        private String description;

        private ErrorBuilder() { }

        public ErrorBuilder description(String description) {
            this.description = description;
            return this;
        }

        public Error build() {
            return new Error(this);
        }

    }
}
