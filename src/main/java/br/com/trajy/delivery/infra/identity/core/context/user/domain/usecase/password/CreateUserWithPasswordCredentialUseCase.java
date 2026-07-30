package br.com.trajy.delivery.infra.identity.core.context.user.domain.usecase.password;

import br.com.trajy.delivery.infra.identity.core.common.exception.model.Error;
import br.com.trajy.delivery.infra.identity.core.common.exception.model.ErrorContext;
import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.aggregate.PasswordCredentialAggregate;
import br.com.trajy.delivery.infra.identity.core.context.credential.ports.PasswordCredentialRepositoryPort;
import br.com.trajy.delivery.infra.identity.core.context.credential.ports.PasswordEncripterPort;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.aggregate.UserAggregate;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.wrapper.input.CreateUserWithPasswordCredentialWrapperInput;
import br.com.trajy.delivery.infra.identity.core.context.user.ports.out.UserRepositoryPort;

import java.util.List;

import static br.com.trajy.delivery.infra.identity.core.common.exception.model.ErrorContext.getErrorContext;
import static br.com.trajy.delivery.infra.identity.core.common.exception.type.BusinessException.checkBusinessExeption;
import static br.com.trajy.delivery.infra.identity.core.context.credential.domain.util.PasswordValidator.validatePassword;
import static br.com.trajy.delivery.infra.identity.core.context.user.domain.model.factory.UserFactory.createUser;
import static br.com.trajy.delivery.infra.identity.core.context.user.domain.util.UserValidator.validateUserUniqueFields;

public class CreateUserWithPasswordCredentialUseCase {

    private final UserRepositoryPort userRepositoryPort;
    private final PasswordCredentialRepositoryPort credentialRepositoryPort;
    private final PasswordEncripterPort passwordEncripterPort;

    public CreateUserWithPasswordCredentialUseCase(
            UserRepositoryPort userRepositoryPort,
            PasswordCredentialRepositoryPort credentialRepositoryPort,
            PasswordEncripterPort passwordEncripterPort
    ) {
        this.userRepositoryPort = userRepositoryPort;
        this.credentialRepositoryPort = credentialRepositoryPort;
        this.passwordEncripterPort = passwordEncripterPort;
    }

    public void execute(CreateUserWithPasswordCredentialWrapperInput input) {
        final ErrorContext<Error> errorContext = getErrorContext(CreateUserWithPasswordCredentialUseCase.class, validateInput(input));
        final UserAggregate user = createUser(input.email());
        final UserAggregate userPersisted = this.userRepositoryPort.save(user);
        final PasswordCredentialAggregate credential = this.passwordEncripterPort.encrypt(input.password());
        credential.setUser(userPersisted);
        this.credentialRepositoryPort.save(credential);
        checkBusinessExeption(errorContext);
    }

    private List<Error> validateInput(CreateUserWithPasswordCredentialWrapperInput input) {
        final List<Error> errors = validatePassword(input.password());
        errors.addAll(validateUserUniqueFields(input, this.userRepositoryPort.findByUniqueFields(input.email())));
        return errors;
    }

}
