package br.com.trajy.delivery.infra.identity.core.feature.password.usecase;

import br.com.trajy.delivery.infra.identity.core.common.exception.model.Error;
import br.com.trajy.delivery.infra.identity.core.common.exception.model.ErrorContext;
import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.aggregate.PasswordCredentialAggregate;
import br.com.trajy.delivery.infra.identity.core.context.credential.ports.PasswordCredentialRepositoryPort;
import br.com.trajy.delivery.infra.identity.core.context.credential.registry.PasswordHashStrategyRegistry;
import br.com.trajy.delivery.infra.identity.core.context.refreshtoken.domain.model.aggregate.RefreshTokenAggregate;
import br.com.trajy.delivery.infra.identity.core.context.refreshtoken.registry.EncryptionStrategyRegistry;
import br.com.trajy.delivery.infra.identity.core.context.session.domain.model.aggregate.SessionAggregate;
import br.com.trajy.delivery.infra.identity.core.context.session.ports.SessionRepositoryPort;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.aggregate.UserAggregate;
import br.com.trajy.delivery.infra.identity.core.feature.password.model.wrapper.input.LoginWithPasswordCredentialWrapperInput;

import static br.com.trajy.delivery.infra.identity.core.common.exception.model.Error.withDescription;
import static br.com.trajy.delivery.infra.identity.core.common.exception.model.ErrorContext.getErrorContext;
import static br.com.trajy.delivery.infra.identity.core.common.exception.type.BusinessException.checkBusinessException;
import static br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.factory.PasswordCredentialFactory.createPasswordCredential;
import static br.com.trajy.delivery.infra.identity.core.context.credential.domain.util.PasswordCredentialValidator.validatePasswordCredentialConsistency;
import static br.com.trajy.delivery.infra.identity.core.context.refreshtoken.domain.model.factory.RefreshTokenFactory.createRefreshToken;
import static br.com.trajy.delivery.infra.identity.core.context.session.domain.model.factory.SessionFactory.createSession;
import static java.util.List.of;
import static java.util.Objects.isNull;

public class LoginWithPasswordCredentialUseCase {

    private final PasswordCredentialRepositoryPort passwordCredentialRepositoryPort;
    private final SessionRepositoryPort sessionRepositoryPort;

    public LoginWithPasswordCredentialUseCase(
            PasswordCredentialRepositoryPort passwordCredentialRepository,
            SessionRepositoryPort sessionRepositoryPort
    ) {
        this.passwordCredentialRepositoryPort = passwordCredentialRepository;
        this.sessionRepositoryPort = sessionRepositoryPort;
    }

    public SessionAggregate execute(LoginWithPasswordCredentialWrapperInput input) {
        final ErrorContext<Error> errorContext = getErrorContext(LoginWithPasswordCredentialUseCase.class);
        final PasswordCredentialAggregate passwordCredentialAggregate = this.passwordCredentialRepositoryPort.findByIdentifier(input.identifier());
        final PasswordCredentialAggregate encryptedPasswordCredentialAggregate = PasswordHashStrategyRegistry.get(passwordCredentialAggregate.getHashAlgorithmType())
                .populateWithEncrypt(createPasswordCredential(input, passwordCredentialAggregate.getUser()), input.password());
        validatePasswordCredentialConsistency(errorContext.getOriginClazz(), encryptedPasswordCredentialAggregate, passwordCredentialAggregate);
        this.validateCredentials(errorContext, passwordCredentialAggregate, input);
        final RefreshTokenAggregate refreshTokenAggregate = createRefreshToken(input);
        EncryptionStrategyRegistry.get(refreshTokenAggregate.getEncryptionType()).populateToken(refreshTokenAggregate, input);
        final SessionAggregate sessionAggregate = createSession(input, passwordCredentialAggregate, of(refreshTokenAggregate));
        final SessionAggregate sessionAggregatePersisted = this.sessionRepositoryPort.save(sessionAggregate);
        checkBusinessException(errorContext);
        return sessionAggregatePersisted;
    }

    private void validateCredentials(ErrorContext<Error> errorContext, PasswordCredentialAggregate passwordCredentialAggregate, LoginWithPasswordCredentialWrapperInput input) {
        if(isNull(passwordCredentialAggregate) || this.identifierMatches(passwordCredentialAggregate.getUser(), input.identifier())) {
            errorContext.appendError(withDescription("Invalid Credentials"));
        }
    }

    private boolean identifierMatches(UserAggregate userAggregate, String identifier) {
        return identifier.equals(userAggregate.getEmail());
    }

}
