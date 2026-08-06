package br.com.trajy.delivery.infra.identity.framework.context.credential.config;

import br.com.trajy.delivery.infra.identity.core.context.credential.ports.PasswordHashStrategyPort;
import br.com.trajy.delivery.infra.identity.core.context.credential.registry.PasswordHashStrategyRegistry;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class PasswordHashStrategyConfig {

    private final List<PasswordHashStrategyPort> strategies;

    @PostConstruct
    public void initializeEncryptionStrategies() {
        PasswordHashStrategyRegistry.initialize(this.strategies);
    }

}
