package br.com.trajy.delivery.infra.identity.adapter.feature.user.config;

import br.com.trajy.delivery.infra.identity.adapter.feature.user.out.UserDataBaseActionsImpl;
import br.com.trajy.delivery.infra.identity.core.feature.user.usecase.CreateUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserInstancesProvider {

    @Bean
    public CreateUserUseCase getCreateUserUseCaseInstance(UserDataBaseActionsImpl userDataBaseActions) {
        return new CreateUserUseCase(userDataBaseActions);
    }

}
