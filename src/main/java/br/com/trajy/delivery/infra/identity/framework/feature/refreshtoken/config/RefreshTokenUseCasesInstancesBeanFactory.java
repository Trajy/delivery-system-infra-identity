package br.com.trajy.delivery.infra.identity.framework.feature.refreshtoken.config;

import br.com.trajy.delivery.infra.identity.core.feature.refreshtoken.usecase.RefreshTokenUseCase;
import br.com.trajy.delivery.infra.identity.framework.common.proxy.TransactionalProxyWrapperBeanFactory;
import br.com.trajy.delivery.infra.identity.framework.context.refreshtoken.adapters.RefreshTokenRepositoryAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RefreshTokenUseCasesInstancesBeanFactory {

    private final TransactionalProxyWrapperBeanFactory transactionalProxyWrapperBeanFactory;

    @Bean
    public RefreshTokenUseCase getRefreshTokenUseCaseInstance(RefreshTokenRepositoryAdapter refreshTokenRepositoryAdapter) {
        final RefreshTokenUseCase useCase = new RefreshTokenUseCase(refreshTokenRepositoryAdapter);
        return this.transactionalProxyWrapperBeanFactory.createProxy(useCase);
    }

}
