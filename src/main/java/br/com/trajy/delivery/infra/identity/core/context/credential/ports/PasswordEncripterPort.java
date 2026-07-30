package br.com.trajy.delivery.infra.identity.core.context.credential.ports;

import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.aggregate.PasswordCredentialAggregate;

public interface PasswordEncripterPort {

    PasswordCredentialAggregate encrypt(String password);

}
