package br.com.trajy.delivery.infra.identity.core.feature.user.usecase;

import br.com.trajy.delivery.infra.identity.core.feature.user.domain.enums.UserStatus;
import br.com.trajy.delivery.infra.identity.core.feature.user.domain.model.User;
import br.com.trajy.delivery.infra.identity.core.feature.user.interfaces.out.UserDataBaseActions;

public class CreateUserUseCase {

    private UserDataBaseActions userDataBaseActions;

    public CreateUserUseCase(UserDataBaseActions userDataBaseActions) {
        this.userDataBaseActions = userDataBaseActions;
    }

    public User execute(User model) {
        model.setStatus(UserStatus.ACTIVE);
        return this.userDataBaseActions.save(model);
    }

}
