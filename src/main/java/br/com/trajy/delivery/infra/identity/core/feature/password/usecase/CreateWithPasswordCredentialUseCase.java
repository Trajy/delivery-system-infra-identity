package br.com.trajy.delivery.infra.identity.core.feature.password.usecase;

import br.com.trajy.delivery.infra.identity.core.common.exception.model.Error;
import br.com.trajy.delivery.infra.identity.core.common.exception.model.ErrorContext;
import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.aggregate.PasswordCredentialAggregate;
import br.com.trajy.delivery.infra.identity.core.context.credential.ports.PasswordCredentialRepositoryPort;
import br.com.trajy.delivery.infra.identity.core.context.credential.registry.PasswordHashStrategyRegistry;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.aggregate.UserAggregate;
import br.com.trajy.delivery.infra.identity.core.context.user.ports.UserRepositoryPort;
import br.com.trajy.delivery.infra.identity.core.feature.password.model.wrapper.input.CreateWithPasswordCredentialWrapperInput;

import java.util.List;

import static br.com.trajy.delivery.infra.identity.core.common.exception.model.ErrorContext.getErrorContext;
import static br.com.trajy.delivery.infra.identity.core.common.exception.type.BusinessException.checkBusinessException;
import static br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.factory.PasswordCredentialFactory.populatePasswordCredential;
import static br.com.trajy.delivery.infra.identity.core.context.credential.domain.util.PasswordCredentialValidator.validatePassword;
import static br.com.trajy.delivery.infra.identity.core.context.user.domain.model.factory.UserFactory.createUser;
import static br.com.trajy.delivery.infra.identity.core.context.user.domain.util.UserValidator.validateUserUniqueFields;

public class CreateWithPasswordCredentialUseCase {

    private final UserRepositoryPort userRepositoryPort;
    private final PasswordCredentialRepositoryPort credentialRepositoryPort;

    public CreateWithPasswordCredentialUseCase(
            UserRepositoryPort userRepositoryPort,
            PasswordCredentialRepositoryPort credentialRepositoryPort
    ) {
        this.userRepositoryPort = userRepositoryPort;
        this.credentialRepositoryPort = credentialRepositoryPort;
    }

    public void execute(CreateWithPasswordCredentialWrapperInput input) {
        final ErrorContext<Error> errorContext = getErrorContext(CreateWithPasswordCredentialUseCase.class);
        this.validateInput(errorContext, input);
        final UserAggregate user = createUser(input.email());
        final PasswordCredentialAggregate passwordCredential = PasswordHashStrategyRegistry.get(input.hashAlgorithmType())
                .createPasswordCredentialAggregate(input.password());
        populatePasswordCredential(passwordCredential, user, input);
        this.credentialRepositoryPort.save(passwordCredential);
        checkBusinessException(errorContext);
    }

    private void validateInput(ErrorContext<Error> errorContext, CreateWithPasswordCredentialWrapperInput input) {
        errorContext.appendErrors(validatePassword(input.password()));
        errorContext.appendErrors(validateUserUniqueFields(input, this.userRepositoryPort.findByUniqueFields(input.email())));
        checkBusinessException(errorContext);
    }

}
