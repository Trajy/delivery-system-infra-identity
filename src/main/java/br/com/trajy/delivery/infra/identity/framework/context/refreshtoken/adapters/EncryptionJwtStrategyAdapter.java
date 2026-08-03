package br.com.trajy.delivery.infra.identity.framework.context.refreshtoken.adapters;

import br.com.trajy.delivery.infra.identity.core.context.refreshtoken.annotation.Encryption;
import br.com.trajy.delivery.infra.identity.core.context.refreshtoken.domain.model.aggregate.RefreshTokenAggregate;
import br.com.trajy.delivery.infra.identity.core.context.refreshtoken.ports.EncryptionStrategyPort;
import br.com.trajy.delivery.infra.identity.core.feature.password.model.wrapper.input.LoginWithPasswordCredentialWrapperInput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static br.com.trajy.delivery.infra.identity.core.context.refreshtoken.domain.model.enums.EncryptionType.JWT;

@Encryption(JWT)
@Component
@RequiredArgsConstructor
public class EncryptionJwtStrategyAdapter implements EncryptionStrategyPort {

    @Override
    public void populateToken(RefreshTokenAggregate aggregate, LoginWithPasswordCredentialWrapperInput input) {
        //TODO implement populateToken
    }

}
