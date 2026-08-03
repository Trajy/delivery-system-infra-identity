package br.com.trajy.delivery.infra.identity.framework.context.refreshtoken.config;

import br.com.trajy.delivery.infra.identity.core.context.refreshtoken.ports.EncryptionStrategyPort;
import br.com.trajy.delivery.infra.identity.core.context.refreshtoken.registry.EncryptionStrategyRegistry;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class EncryptionStrategyConfig {

    private final List<EncryptionStrategyPort> strategies;

    @PostConstruct
    public void initializeEncryptionStrategies() {
        EncryptionStrategyRegistry.initialize(this.strategies);
    }

}
