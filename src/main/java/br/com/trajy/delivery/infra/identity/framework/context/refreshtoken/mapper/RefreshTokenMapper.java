package br.com.trajy.delivery.infra.identity.framework.context.refreshtoken.mapper;

import br.com.trajy.delivery.infra.identity.core.context.refreshtoken.domain.model.aggregate.RefreshTokenAggregate;
import br.com.trajy.delivery.infra.identity.framework.context.refreshtoken.model.RefreshTokenEntity;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface RefreshTokenMapper {

    RefreshTokenAggregate toAggregate(RefreshTokenEntity entity);

    RefreshTokenEntity toEntity(RefreshTokenAggregate aggregate);

}
