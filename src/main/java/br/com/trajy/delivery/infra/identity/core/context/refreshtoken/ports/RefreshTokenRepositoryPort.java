package br.com.trajy.delivery.infra.identity.core.context.refreshtoken.ports;

import br.com.trajy.delivery.infra.identity.core.common.interfaces.BaseRepositoryPort;
import br.com.trajy.delivery.infra.identity.core.context.refreshtoken.domain.model.aggregate.RefreshTokenAggregate;

import java.util.UUID;

public interface RefreshTokenRepositoryPort extends BaseRepositoryPort<RefreshTokenAggregate, UUID> {

}
