package br.com.trajy.delivery.infra.identity.framework.context.credential.adapters;

import br.com.trajy.delivery.infra.identity.core.context.credential.annotation.HashAlgorithm;
import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.aggregate.PasswordCredentialAggregate;
import br.com.trajy.delivery.infra.identity.core.context.credential.ports.PasswordHashStrategyPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.enums.HashAlgorithmType.BCRYPT;

@HashAlgorithm(BCRYPT)
@Component
@RequiredArgsConstructor
public class PasswordHashStrategyAdapter implements PasswordHashStrategyPort {

    @Override
    public PasswordCredentialAggregate populateWithEncrypt(PasswordCredentialAggregate aggregate, String password) {
        //TODO - populateWithEncrypt
        return new PasswordCredentialAggregate();
    }
}
