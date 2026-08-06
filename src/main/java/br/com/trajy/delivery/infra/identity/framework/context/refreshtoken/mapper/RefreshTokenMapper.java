package br.com.trajy.delivery.infra.identity.framework.context.refreshtoken.mapper;

import br.com.trajy.delivery.infra.identity.core.context.refreshtoken.domain.model.aggregate.RefreshTokenAggregate;
import br.com.trajy.delivery.infra.identity.core.feature.refreshtoken.model.wrapper.RefreshTokenWrapperInput;
import br.com.trajy.delivery.infra.identity.core.feature.refreshtoken.model.wrapper.RefreshTokenWrapperOutput;
import br.com.trajy.delivery.infra.identity.framework.context.refreshtoken.model.RefreshTokenEntity;
import br.com.trajy.delivery.infra.identity.framework.context.refreshtoken.model.RefreshTokenRequestModel;
import br.com.trajy.delivery.infra.identity.framework.context.refreshtoken.model.RefreshTokenResponseModel;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface RefreshTokenMapper {

    RefreshTokenAggregate toAggregate(RefreshTokenEntity entity);

    RefreshTokenEntity toEntity(RefreshTokenAggregate aggregate);

    RefreshTokenWrapperInput toInput(RefreshTokenRequestModel requestModel);

    RefreshTokenResponseModel toResponse(RefreshTokenWrapperOutput wrapperOutput);

}
