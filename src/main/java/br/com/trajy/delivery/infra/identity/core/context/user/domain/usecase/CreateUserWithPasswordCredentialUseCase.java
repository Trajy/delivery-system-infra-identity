package br.com.trajy.delivery.infra.identity.core.context.user.domain.usecase;

import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.aggregate.PasswordCredential;
import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.factory.PasswordCredentialFactory;
import br.com.trajy.delivery.infra.identity.core.context.credential.ports.PasswordCredentialRepositoryPort;
import br.com.trajy.delivery.infra.identity.core.context.credential.ports.PasswordEncripterPort;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.wrapper.input.CreateUserWithPasswordCredentialWrapperInput;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.aggregate.User;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.factory.UserFactory;
import br.com.trajy.delivery.infra.identity.core.context.user.ports.out.UserRepositoryPort;

public class CreateUserWithPasswordCredentialUseCase {

    private final UserRepositoryPort userDataBaseActions;
    private final PasswordCredentialRepositoryPort credentialDataBaseActions;
    private final PasswordEncripterPort passwordEncripterPort;

    public CreateUserWithPasswordCredentialUseCase(
            UserRepositoryPort userDataBaseActions,
            PasswordCredentialRepositoryPort credentialDataBaseActions,
            PasswordEncripterPort passwordEncripterPort
    ) {
        this.userDataBaseActions = userDataBaseActions;
        this.credentialDataBaseActions = credentialDataBaseActions;
        this.passwordEncripterPort = passwordEncripterPort;
    }

    public User execute(CreateUserWithPasswordCredentialWrapperInput input) {
        final User user = UserFactory.createUser(input.email());
        final User userPersisted = this.userDataBaseActions.save(user);
        final PasswordCredential credential = PasswordCredentialFactory.create(user, this.passwordEncripterPort.encrypt(input.password()), this.passwordEncripterPort.getHashAlgorithmType());
        this.credentialDataBaseActions.save(credential);
        return userPersisted;
    }

}
