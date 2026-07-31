package br.com.trajy.delivery.infra.identity.core.context.session.ports;

import br.com.trajy.delivery.infra.identity.core.common.interfaces.BaseRepositoryPort;
import br.com.trajy.delivery.infra.identity.core.context.session.domain.model.aggregate.SessionAggregate;

import java.util.UUID;

public interface SessionRepositoryPort extends BaseRepositoryPort<SessionAggregate, UUID> {

}
