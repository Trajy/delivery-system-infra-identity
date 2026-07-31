package br.com.trajy.delivery.infra.identity.core.feature.password.usecase;

import br.com.trajy.delivery.infra.identity.core.common.exception.model.Error;
import br.com.trajy.delivery.infra.identity.core.common.exception.model.ErrorContext;
import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.aggregate.PasswordCredentialAggregate;
import br.com.trajy.delivery.infra.identity.core.context.credential.ports.PasswordCredentialRepositoryPort;
import br.com.trajy.delivery.infra.identity.core.context.credential.ports.PasswordEncripterPort;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.aggregate.UserAggregate;
import br.com.trajy.delivery.infra.identity.core.feature.password.model.wrapper.input.CreateUserWithPasswordCredentialWrapperInput;
import br.com.trajy.delivery.infra.identity.core.context.user.ports.UserRepositoryPort;

import java.util.List;

import static br.com.trajy.delivery.infra.identity.core.common.exception.model.ErrorContext.getErrorContext;
import static br.com.trajy.delivery.infra.identity.core.common.exception.type.BusinessException.checkBusinessException;
import static br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.factory.PasswordCredentialFactory.createPasswordCredential;
import static br.com.trajy.delivery.infra.identity.core.context.credential.domain.util.PasswordCredentialValidator.validatePassword;
import static br.com.trajy.delivery.infra.identity.core.context.user.domain.model.factory.UserFactory.createUser;
import static br.com.trajy.delivery.infra.identity.core.context.user.domain.util.UserValidator.validateUserUniqueFields;

public class CreateWithPasswordCredentialUseCase {

    private final UserRepositoryPort userRepositoryPort;
    private final PasswordCredentialRepositoryPort credentialRepositoryPort;
    private final PasswordEncripterPort passwordEncripterPort;

    public CreateWithPasswordCredentialUseCase(
            UserRepositoryPort userRepositoryPort,
            PasswordCredentialRepositoryPort credentialRepositoryPort,
            PasswordEncripterPort passwordEncripterPort
    ) {
        this.userRepositoryPort = userRepositoryPort;
        this.credentialRepositoryPort = credentialRepositoryPort;
        this.passwordEncripterPort = passwordEncripterPort;
    }

    public void execute(CreateUserWithPasswordCredentialWrapperInput input) {
        final ErrorContext<Error> errorContext = getErrorContext(CreateWithPasswordCredentialUseCase.class, validateInput(input));
        final UserAggregate user = createUser(input.email());
        final PasswordCredentialAggregate passwordCredential = createPasswordCredential(user);
        this.passwordEncripterPort.populateWithEncrypt(passwordCredential, input.password());
        this.credentialRepositoryPort.save(passwordCredential);
        checkBusinessException(errorContext);
    }

    private List<Error> validateInput(CreateUserWithPasswordCredentialWrapperInput input) {
        final List<Error> errors = validatePassword(input.password());
        errors.addAll(validateUserUniqueFields(input, this.userRepositoryPort.findByUniqueFields(input.email())));
        return errors;
    }

}
