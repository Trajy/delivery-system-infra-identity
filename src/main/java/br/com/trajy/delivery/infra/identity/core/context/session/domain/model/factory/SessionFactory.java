package br.com.trajy.delivery.infra.identity.core.context.session.domain.model.factory;

import br.com.trajy.delivery.infra.identity.core.context.session.domain.model.aggregate.SessionAggregate;
import br.com.trajy.delivery.infra.identity.core.context.refreshtoken.domain.model.aggregate.RefreshTokenAggregate;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.aggregate.UserAggregate;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.wrapper.input.LoginWithPasswordCredentialWrapperInput;

import java.util.List;

import static br.com.trajy.delivery.infra.identity.core.common.exception.type.UnsupportedInstantiationException.utilityClassUnsupportedInstantiationException;
import static br.com.trajy.delivery.infra.identity.core.context.session.domain.model.enums.SessionStatusType.ACTIVE;

public final class SessionFactory {

    private SessionFactory () {
        utilityClassUnsupportedInstantiationException();
    }

    public static SessionAggregate createSession(LoginWithPasswordCredentialWrapperInput input, UserAggregate userAggregate, List<RefreshTokenAggregate> refreshTokenAggregates) {
        final SessionAggregate aggregate = new SessionAggregate();
        aggregate.setUser(userAggregate);
        aggregate.setTokens(refreshTokenAggregates);
        aggregate.setStatus(ACTIVE);
        return aggregate;
    }

}
