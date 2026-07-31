package br.com.trajy.delivery.infra.identity.framework.context.credential.adapters;

import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.aggregate.PasswordCredentialAggregate;
import br.com.trajy.delivery.infra.identity.core.context.credential.ports.PasswordEncripterPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PasswordEncripterAdapter implements PasswordEncripterPort {

    @Override
    public void populateWithEncrypt(PasswordCredentialAggregate aggregate, String password) {
        //TODO - populateWithEncrypt
    }
}
