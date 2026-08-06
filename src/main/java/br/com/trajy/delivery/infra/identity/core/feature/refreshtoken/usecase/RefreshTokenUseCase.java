package br.com.trajy.delivery.infra.identity.core.feature.refreshtoken.usecase;

import br.com.trajy.delivery.infra.identity.core.common.exception.model.ErrorContext;
import br.com.trajy.delivery.infra.identity.core.context.refreshtoken.domain.model.aggregate.RefreshTokenAggregate;
import br.com.trajy.delivery.infra.identity.core.context.refreshtoken.ports.RefreshTokenRepositoryPort;
import br.com.trajy.delivery.infra.identity.core.context.refreshtoken.registry.EncryptionStrategyRegistry;
import br.com.trajy.delivery.infra.identity.core.feature.refreshtoken.model.wrapper.RefreshTokenWrapperInput;
import br.com.trajy.delivery.infra.identity.core.feature.refreshtoken.model.wrapper.RefreshTokenWrapperOutput;

import static br.com.trajy.delivery.infra.identity.core.common.exception.type.BusinessException.checkBusinessException;

public class RefreshTokenUseCase {

    private final RefreshTokenRepositoryPort refreshTokenRepositoryPort;

    public RefreshTokenUseCase(RefreshTokenRepositoryPort refreshTokenRepositoryPort) {
        this.refreshTokenRepositoryPort = refreshTokenRepositoryPort;
    }

    public RefreshTokenWrapperOutput execute(RefreshTokenWrapperInput input) {
        final ErrorContext<Error> errorContext = ErrorContext.getErrorContext(RefreshTokenUseCase.class);
        final RefreshTokenAggregate refreshTokenAggregate = this.refreshTokenRepositoryPort.findByRefreshTokenHash(input.refreshToken());
        EncryptionStrategyRegistry.get(refreshTokenAggregate.getEncryptionType()).populateToken(refreshTokenAggregate, input);
        checkBusinessException(errorContext);
        //TODO - implement the logic to generate a new refresh token and return it
        return new RefreshTokenWrapperOutput("", "", "", "");
    }

}
