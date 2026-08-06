package br.com.trajy.delivery.infra.identity.core.context.refreshtoken.registry;

import br.com.trajy.delivery.infra.identity.core.context.refreshtoken.annotation.Encryption;
import br.com.trajy.delivery.infra.identity.core.context.refreshtoken.domain.model.enums.EncryptionType;
import br.com.trajy.delivery.infra.identity.core.context.refreshtoken.ports.EncryptionStrategyPort;

import java.util.List;
import java.util.Map;

import static br.com.trajy.delivery.infra.identity.core.common.exception.type.UnsupportedInstantiationException.utilityClassUnsupportedInstantiationException;
import static br.com.trajy.delivery.infra.identity.core.common.utils.AnnotationUtils.resolve;
import static java.lang.String.format;
import static java.util.Objects.isNull;
import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.toUnmodifiableMap;

public final class EncryptionStrategyRegistry {

    private static Map<EncryptionType, EncryptionStrategyPort> strategies;

    private EncryptionStrategyRegistry() {
        utilityClassUnsupportedInstantiationException();
    }

    public static void initialize(final List<EncryptionStrategyPort> strategies) {
        EncryptionStrategyRegistry.strategies = strategies.stream()
                .collect(toUnmodifiableMap(strategyPort -> resolve(strategyPort, Encryption.class).value(), identity()));
    }

    public static EncryptionStrategyPort get(final EncryptionType type) {
        if (isNull(strategies) || strategies.isEmpty()) {
            throw new IllegalStateException(format("%s not initialized.", EncryptionStrategyRegistry.class.getName()));
        }
        final EncryptionStrategyPort strategy = strategies.get(type);
        if (strategy == null) {
            throw new IllegalArgumentException(format("Unsupported encryption: %s", type.getClass().getSimpleName()));
        }
        return strategy;
    }

}
