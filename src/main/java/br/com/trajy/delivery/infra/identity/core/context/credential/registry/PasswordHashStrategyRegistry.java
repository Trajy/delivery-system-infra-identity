package br.com.trajy.delivery.infra.identity.core.context.credential.registry;


import br.com.trajy.delivery.infra.identity.core.context.credential.annotation.HashAlgorithm;
import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.enums.HashAlgorithmType;
import br.com.trajy.delivery.infra.identity.core.context.credential.ports.PasswordHashStrategyPort;
import br.com.trajy.delivery.infra.identity.core.context.refreshtoken.registry.EncryptionStrategyRegistry;

import java.util.List;
import java.util.Map;

import static br.com.trajy.delivery.infra.identity.core.common.exception.type.UnsupportedInstantiationException.utilityClassUnsupportedInstantiationException;
import static br.com.trajy.delivery.infra.identity.core.common.utils.AnnotationUtils.resolve;
import static java.lang.String.format;
import static java.util.Objects.isNull;
import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.toUnmodifiableMap;

public final class PasswordHashStrategyRegistry {

    private static Map<HashAlgorithmType, PasswordHashStrategyPort> strategies;

    private PasswordHashStrategyRegistry() {
        utilityClassUnsupportedInstantiationException();
    }

    public static void initialize(final List<PasswordHashStrategyPort> strategies) {
        PasswordHashStrategyRegistry.strategies = strategies.stream()
                .collect(toUnmodifiableMap(strategyPort -> resolve(strategyPort, HashAlgorithm.class).value(), identity()));
    }

    public static PasswordHashStrategyPort get(final HashAlgorithmType type) {
        if (isNull(strategies) || strategies.isEmpty()) {
            throw new IllegalStateException(format("%s not initialized.", EncryptionStrategyRegistry.class.getName()));
        }
        final PasswordHashStrategyPort strategy = strategies.get(type);
        if (strategy == null) {
            throw new IllegalArgumentException(format("Unsupported encryption: %s", type.getClass().getSimpleName()));
        }
        return strategy;
    }

}
