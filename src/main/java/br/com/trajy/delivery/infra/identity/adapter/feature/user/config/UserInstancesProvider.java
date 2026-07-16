package br.com.trajy.delivery.infra.identity.adapter.feature.user.config;

import br.com.trajy.delivery.infra.identity.adapter.feature.credential.out.PasswordCredentialDatabaseActionsImpl;
import br.com.trajy.delivery.infra.identity.adapter.feature.credential.util.PasswordEncripterImpl;
import br.com.trajy.delivery.infra.identity.adapter.feature.user.out.UserDataBaseActionsImpl;
import br.com.trajy.delivery.infra.identity.core.feature.user.usecase.CreateUserWithPasswordCredentialUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserInstancesProvider {

    @Bean
    public CreateUserWithPasswordCredentialUseCase getCreateUserUseCaseInstance(
            UserDataBaseActionsImpl userDataBaseActions,
            PasswordCredentialDatabaseActionsImpl passwordCredentialDatabaseActions,
            PasswordEncripterImpl passwordEncripter
    ) {
        return new CreateUserWithPasswordCredentialUseCase(
                userDataBaseActions,
                passwordCredentialDatabaseActions,
                passwordEncripter
        );
    }

}
