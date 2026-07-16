package br.com.trajy.delivery.infra.identity.core.feature.user.usecase;

import br.com.trajy.delivery.infra.identity.core.feature.credential.domain.model.PasswordCredential;
import br.com.trajy.delivery.infra.identity.core.feature.credential.domain.modelfactory.PasswordCredentialFactory;
import br.com.trajy.delivery.infra.identity.core.feature.credential.interfaces.PasswordCredentialDataBaseActions;
import br.com.trajy.delivery.infra.identity.core.feature.credential.interfaces.PasswordEncripter;
import br.com.trajy.delivery.infra.identity.core.feature.user.domain.enums.UserStatus;
import br.com.trajy.delivery.infra.identity.core.feature.user.domain.input.CreateUserWithPasswordCredentialInput;
import br.com.trajy.delivery.infra.identity.core.feature.user.domain.model.User;
import br.com.trajy.delivery.infra.identity.core.feature.user.domain.modelfactory.UserFactory;
import br.com.trajy.delivery.infra.identity.core.feature.user.interfaces.out.UserDataBaseActions;

public class CreateUserWithPasswordCredentialUseCase {

    private final UserDataBaseActions userDataBaseActions;
    private final PasswordCredentialDataBaseActions credentialDataBaseActions;
    private final PasswordEncripter passwordEncripter;

    public CreateUserWithPasswordCredentialUseCase(
            UserDataBaseActions userDataBaseActions,
            PasswordCredentialDataBaseActions credentialDataBaseActions,
            PasswordEncripter passwordEncripter
    ) {
        this.userDataBaseActions = userDataBaseActions;
        this.credentialDataBaseActions = credentialDataBaseActions;
        this.passwordEncripter = passwordEncripter;
    }

    public User execute(CreateUserWithPasswordCredentialInput input) {
        final User user = UserFactory.createUser(input.email());
        user.setStatus(UserStatus.ACTIVE);
        final User userPersisted = this.userDataBaseActions.save(user);
        final PasswordCredential credential = PasswordCredentialFactory.create(user, this.passwordEncripter.encrypt(input.password()), this.passwordEncripter.getHashAlgorithmType());
        credential.setUser(userPersisted);
        this.credentialDataBaseActions.save(credential);
        return userPersisted;
    }

}
