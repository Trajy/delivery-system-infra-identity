package br.com.trajy.delivery.infra.identity.framework.context.credential.adapters;

import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.aggregate.PasswordCredentialAggregate;
import br.com.trajy.delivery.infra.identity.core.context.credential.ports.PasswordEncripterPort;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncripterAdapter implements PasswordEncripterPort {


    @Override
    public PasswordCredentialAggregate encrypt(String password) {
        //TODO - Implementar a lógica de encriptação de senha
        return null;
    }
}
