package br.com.trajy.delivery.infra.identity.core.context.refreshtoken.ports;

import br.com.trajy.delivery.infra.identity.core.context.refreshtoken.domain.model.aggregate.RefreshTokenAggregate;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.wrapper.input.LoginWithPasswordCredentialWrapperInput;

public interface TokenGenerationPort {

    void populateToken(RefreshTokenAggregate aggregate, LoginWithPasswordCredentialWrapperInput input);

}
