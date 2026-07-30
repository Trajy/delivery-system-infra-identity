package br.com.trajy.delivery.infra.identity.framework.context.user.config;

import br.com.trajy.delivery.infra.identity.framework.common.proxy.TransactionalProxyWrapperBeanFactory;
import br.com.trajy.delivery.infra.identity.framework.context.credential.adapters.PasswordCredentialRepositoryAdapter;
import br.com.trajy.delivery.infra.identity.framework.context.credential.adapters.PasswordEncripterAdapter;
import br.com.trajy.delivery.infra.identity.framework.context.user.adapters.UserRepositoryAdapter;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.usecase.password.CreateUserWithPasswordCredentialUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class UserInstancesBeanFactory {

    private final TransactionalProxyWrapperBeanFactory transactionalProxyWrapperBeanFactory;

    @Bean
    public CreateUserWithPasswordCredentialUseCase getCreateUserWithPasswordCredentialUseCaseInstance(
            UserRepositoryAdapter userRepositoryAdapter,
            PasswordCredentialRepositoryAdapter passwordCredentialRepositoryAdapter,
            PasswordEncripterAdapter passwordEncripterAdapter
    ) {
        final CreateUserWithPasswordCredentialUseCase useCase = new CreateUserWithPasswordCredentialUseCase(
                userRepositoryAdapter,
                passwordCredentialRepositoryAdapter,
                passwordEncripterAdapter
        );
        return this.transactionalProxyWrapperBeanFactory.createProxy(useCase);
    }

}
