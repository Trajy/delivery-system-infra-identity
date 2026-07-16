package br.com.trajy.delivery.infra.identity.core.context.user.domain.usecase;

import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.aggregate.PasswordCredentialAggregate;
import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.factory.PasswordCredentialFactory;
import br.com.trajy.delivery.infra.identity.core.context.credential.ports.PasswordCredentialRepositoryPort;
import br.com.trajy.delivery.infra.identity.core.context.credential.ports.PasswordEncripterPort;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.aggregate.UserAggregate;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.factory.UserFactory;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.wrapper.input.CreateUserWithPasswordCredentialWrapperInput;
import br.com.trajy.delivery.infra.identity.core.context.user.ports.out.UserRepositoryPort;

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

    public UserAggregate execute(CreateUserWithPasswordCredentialWrapperInput input) {
        final UserAggregate user = UserFactory.createUser(input.email());
        final UserAggregate userPersisted = this.userRepositoryPort.save(user);
        final PasswordCredentialAggregate credential = PasswordCredentialFactory.create(userPersisted, this.passwordEncripterPort.encrypt(input.password()), this.passwordEncripterPort.getHashAlgorithmType());
        this.credentialRepositoryPort.save(credential);
        return userPersisted;
    }

}
