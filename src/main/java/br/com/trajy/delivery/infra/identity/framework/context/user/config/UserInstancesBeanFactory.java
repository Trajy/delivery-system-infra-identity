package br.com.trajy.delivery.infra.identity.framework.context.user.config;

import br.com.trajy.delivery.infra.identity.framework.common.proxy.TransactionalProxyWrapperBeanFactory;
import br.com.trajy.delivery.infra.identity.framework.context.credential.adapters.PasswordCredentialRepositoryAdapter;
import br.com.trajy.delivery.infra.identity.framework.context.credential.adapters.PasswordEncripterAdapter;
import br.com.trajy.delivery.infra.identity.framework.context.user.adapters.UserRepositoryAdapter;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.usecase.CreateUserWithPasswordCredentialUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class UserInstancesBeanFactory {

    private final TransactionalProxyWrapperBeanFactory transactionalProxyWrapperBeanFactory;

    @Bean
    public CreateUserWithPasswordCredentialUseCase getCreateUserUseCaseInstance(
            UserRepositoryAdapter userDataBaseActions,
            PasswordCredentialRepositoryAdapter passwordCredentialDatabaseActions,
            PasswordEncripterAdapter passwordEncripter
    ) {
        final CreateUserWithPasswordCredentialUseCase useCase = new CreateUserWithPasswordCredentialUseCase(
                userDataBaseActions,
                passwordCredentialDatabaseActions,
                passwordEncripter
        );

        return this.transactionalProxyWrapperBeanFactory.createProxy(useCase);
    }

}
