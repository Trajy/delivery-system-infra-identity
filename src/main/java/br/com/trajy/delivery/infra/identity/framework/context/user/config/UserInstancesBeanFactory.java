package br.com.trajy.delivery.infra.identity.framework.context.user.config;

import br.com.trajy.delivery.infra.identity.framework.context.credential.adapters.PasswordCredentialRepositoryAdapter;
import br.com.trajy.delivery.infra.identity.framework.context.credential.adapters.PasswordEncripterAdapter;
import br.com.trajy.delivery.infra.identity.framework.context.user.adapters.UserRepositoryAdapter;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.usecase.CreateUserWithPasswordCredentialUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserInstancesProvider {

    @Bean
    public CreateUserWithPasswordCredentialUseCase getCreateUserUseCaseInstance(
            UserRepositoryAdapter userDataBaseActions,
            PasswordCredentialRepositoryAdapter passwordCredentialDatabaseActions,
            PasswordEncripterAdapter passwordEncripter
    ) {
        return new CreateUserWithPasswordCredentialUseCase(
                userDataBaseActions,
                passwordCredentialDatabaseActions,
                passwordEncripter
        );
    }

}
