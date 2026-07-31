package br.com.trajy.delivery.infra.identity.core.context.user.ports;

import br.com.trajy.delivery.infra.identity.core.common.interfaces.BaseRepositoryPort;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.aggregate.UserAggregate;

public interface UserRepositoryPort extends BaseRepositoryPort<UserAggregate, Long> {

    UserAggregate findByUniqueFields(String email);

    UserAggregate findByIdentifier(String identifier);

}
