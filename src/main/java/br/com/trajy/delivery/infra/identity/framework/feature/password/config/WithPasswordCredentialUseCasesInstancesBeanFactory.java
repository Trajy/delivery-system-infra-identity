package br.com.trajy.delivery.infra.identity.framework.feature.password.config;

import br.com.trajy.delivery.infra.identity.core.feature.password.usecase.LoginWithPasswordCredentialUseCase;
import br.com.trajy.delivery.infra.identity.framework.common.proxy.TransactionalProxyWrapperBeanFactory;
import br.com.trajy.delivery.infra.identity.framework.context.credential.adapters.PasswordCredentialRepositoryAdapter;
import br.com.trajy.delivery.infra.identity.framework.context.credential.adapters.PasswordEncripterAdapter;
import br.com.trajy.delivery.infra.identity.framework.context.refreshtoken.adapters.TokenGenerationAdapter;
import br.com.trajy.delivery.infra.identity.framework.context.session.adapters.SessionRepositoryAdapter;
import br.com.trajy.delivery.infra.identity.framework.context.user.adapters.UserRepositoryAdapter;
import br.com.trajy.delivery.infra.identity.core.feature.password.usecase.CreateWithPasswordCredentialUseCase;
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
            PasswordCredentialRepositoryAdapter passwordCredentialRepositoryAdapter,
            PasswordEncripterAdapter passwordEncripterAdapter
    ) {
        final CreateWithPasswordCredentialUseCase useCase = new CreateWithPasswordCredentialUseCase(
                userRepositoryAdapter,
                passwordCredentialRepositoryAdapter,
                passwordEncripterAdapter
        );
        return this.transactionalProxyWrapperBeanFactory.createProxy(useCase);
    }

    @Bean
    public LoginWithPasswordCredentialUseCase getLoginWithPasswordCredentialUseCaseInstance(
            PasswordCredentialRepositoryAdapter passwordCredentialRepositoryAdapter,
            PasswordEncripterAdapter passwordEncripterAdapter,
            SessionRepositoryAdapter sessionRepositoryAdapter,
            TokenGenerationAdapter tokenGenerationAdapter
    ) {
        final LoginWithPasswordCredentialUseCase usecase = new LoginWithPasswordCredentialUseCase(
                passwordCredentialRepositoryAdapter,
                passwordEncripterAdapter,
                sessionRepositoryAdapter,
                tokenGenerationAdapter
        );
        return this.transactionalProxyWrapperBeanFactory.createProxy(usecase);
    }

}
