package br.com.trajy.delivery.infra.identity.core.common.exception.type;

import br.com.trajy.delivery.infra.identity.core.common.exception.model.ErrorContext;

public class BusinessException extends RuntimeException {

    private final ErrorContext<?> errorContext;

    public BusinessException(ErrorContext<?> context) {
        super();
        this.errorContext = context;
    }

    public ErrorContext<?> getErrorContext() {
        return errorContext;
    }

    public static void checkBusinessExeption(ErrorContext errorContext) {
        if(errorContext != null && errorContext.getErrors() != null && !errorContext.getErrors().isEmpty()) {
            throw new BusinessException(errorContext);
        }
    }

}
