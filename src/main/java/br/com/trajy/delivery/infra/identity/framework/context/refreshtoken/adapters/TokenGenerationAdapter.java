package br.com.trajy.delivery.infra.identity.framework.context.refreshtoken.adapters;

import br.com.trajy.delivery.infra.identity.core.context.refreshtoken.domain.model.aggregate.RefreshTokenAggregate;
import br.com.trajy.delivery.infra.identity.core.context.refreshtoken.ports.TokenGenerationPort;
import br.com.trajy.delivery.infra.identity.core.feature.password.model.wrapper.input.LoginWithPasswordCredentialWrapperInput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TokenGenerationAdapter implements TokenGenerationPort {

    @Override
    public void populateToken(RefreshTokenAggregate aggregate, LoginWithPasswordCredentialWrapperInput input) {
        //TODO implement populateToken
    }

}
