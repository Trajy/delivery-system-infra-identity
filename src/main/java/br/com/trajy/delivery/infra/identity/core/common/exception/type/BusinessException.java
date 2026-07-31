package br.com.trajy.delivery.infra.identity.core.common.exception.type;

import br.com.trajy.delivery.infra.identity.core.common.exception.model.ErrorContext;

import static java.util.Objects.nonNull;

public class BusinessException extends RuntimeException {

    private final ErrorContext<?> errorContext;

    public <E> BusinessException(ErrorContext<E> context) {
        this.errorContext = context;
    }

    public ErrorContext<?> getErrorContext() {
        return errorContext;
    }

    public static <E> void checkBusinessException(ErrorContext<E> errorContext) {
        if(nonNull(errorContext) && nonNull(errorContext.getErrors()) && !errorContext.getErrors().isEmpty()) {
            throw new BusinessException(errorContext);
        }
    }

}
