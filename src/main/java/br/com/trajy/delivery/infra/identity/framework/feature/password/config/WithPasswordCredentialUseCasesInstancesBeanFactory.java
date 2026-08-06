package br.com.trajy.delivery.infra.identity.framework.feature.password.config;

import br.com.trajy.delivery.infra.identity.core.feature.password.usecase.CreateWithPasswordCredentialUseCase;
import br.com.trajy.delivery.infra.identity.core.feature.password.usecase.LoginWithPasswordCredentialUseCase;
import br.com.trajy.delivery.infra.identity.framework.common.proxy.TransactionalProxyWrapperBeanFactory;
import br.com.trajy.delivery.infra.identity.framework.context.credential.adapters.PasswordCredentialRepositoryAdapter;
import br.com.trajy.delivery.infra.identity.framework.context.session.adapters.SessionRepositoryAdapter;
import br.com.trajy.delivery.infra.identity.framework.context.user.adapters.UserRepositoryAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class WithPasswordCredentialUseCasesInstancesBeanFactory {

    private final TransactionalProxyWrapperBeanFactory transactionalProxyWrapperBeanFactory;

    @Bean
    public CreateWithPasswordCredentialUseCase getCreateUserWithPasswordCredentialUseCaseInstance(
            UserRepositoryAdapter userRepositoryAdapter,
            PasswordCredentialRepositoryAdapter passwordCredentialRepositoryAdapter
    ) {
        final CreateWithPasswordCredentialUseCase useCase = new CreateWithPasswordCredentialUseCase(
                userRepositoryAdapter,
                passwordCredentialRepositoryAdapter
        );
        return this.transactionalProxyWrapperBeanFactory.createProxy(useCase);
    }

    @Bean
    public LoginWithPasswordCredentialUseCase getLoginWithPasswordCredentialUseCaseInstance(
            PasswordCredentialRepositoryAdapter passwordCredentialRepositoryAdapter,
            SessionRepositoryAdapter sessionRepositoryAdapter
    ) {
        final LoginWithPasswordCredentialUseCase usecase = new LoginWithPasswordCredentialUseCase(
                passwordCredentialRepositoryAdapter,
                sessionRepositoryAdapter
        );
        return this.transactionalProxyWrapperBeanFactory.createProxy(usecase);
    }

}
