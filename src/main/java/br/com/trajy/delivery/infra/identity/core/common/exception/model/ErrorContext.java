package br.com.trajy.delivery.infra.identity.core.common.exception.model;

import java.util.ArrayList;
import java.util.List;

public class ErrorContext<T> {

    private final Class<?> originClazz;
    private final List<T> errors = new ArrayList<>();

    private ErrorContext(ErrorContextBuilder<T> builder) {
        this.originClazz = builder.originClazz;
        this.errors.addAll(builder.errors);
    }

    public Class<?> getOriginClazz() {
        return originClazz;
    }

    public List<T> getErrors() {
        return errors;
    }

    public void appendErrors(List<T> additionalErrors) {
        if (additionalErrors != null && !additionalErrors.isEmpty()) {
            this.errors.addAll(additionalErrors);
        }
    }

    public static <T> ErrorContextBuilder<T> builder() {
        return new ErrorContextBuilder<>();
    }

    public static class ErrorContextBuilder<T> {

        private Class<?> originClazz;
        private List<T> errors;

        private ErrorContextBuilder() { }

        public ErrorContextBuilder<T> originClazz(Class<?> originClazz) {
            this.originClazz = originClazz;
            return this;
        }

        public ErrorContextBuilder<T> errors(List<T> errors) {
            this.errors = errors;
            return this;
        }

        public ErrorContext<T> build() {
            return new ErrorContext<>(this);
        }
    }

}
