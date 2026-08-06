package br.com.trajy.delivery.infra.identity.core.context.refreshtoken.ports;

import br.com.trajy.delivery.infra.identity.core.context.refreshtoken.domain.model.aggregate.RefreshTokenAggregate;
import br.com.trajy.delivery.infra.identity.core.feature.password.model.wrapper.input.LoginWithPasswordCredentialWrapperInput;
import br.com.trajy.delivery.infra.identity.core.feature.refreshtoken.model.wrapper.RefreshTokenWrapperInput;

public interface EncryptionStrategyPort {

    void populateToken(RefreshTokenAggregate aggregate, LoginWithPasswordCredentialWrapperInput input);

    void populateToken(RefreshTokenAggregate aggregate, RefreshTokenWrapperInput input);

}
