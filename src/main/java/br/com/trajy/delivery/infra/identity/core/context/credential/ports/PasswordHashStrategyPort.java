package br.com.trajy.delivery.infra.identity.core.context.credential.ports;

import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.aggregate.PasswordCredentialAggregate;

public interface PasswordHashStrategyPort {

    PasswordCredentialAggregate createPasswordCredentialAggregate(String password);

    Boolean matches(String password, PasswordCredentialAggregate passwordCredentialAggregate);

}
