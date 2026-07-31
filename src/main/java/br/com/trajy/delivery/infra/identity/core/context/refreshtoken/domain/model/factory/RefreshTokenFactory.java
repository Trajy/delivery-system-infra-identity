package br.com.trajy.delivery.infra.identity.core.context.refreshtoken.domain.model.factory;

import br.com.trajy.delivery.infra.identity.core.context.refreshtoken.domain.model.aggregate.RefreshTokenAggregate;

import static br.com.trajy.delivery.infra.identity.core.common.exception.type.UnsupportedInstantiationException.utilityClassUnsupportedInstantiationException;
import static br.com.trajy.delivery.infra.identity.core.context.refreshtoken.domain.model.enums.RefreshTokenStatusType.ACTIVE;

public final class RefreshTokenFactory {

    private RefreshTokenFactory() {
        utilityClassUnsupportedInstantiationException();
    }

    public static RefreshTokenAggregate createRefreshToken() {
        final RefreshTokenAggregate aggregate = new RefreshTokenAggregate();
        aggregate.setStatus(ACTIVE);
        return aggregate;
    }

}
