package br.com.trajy.delivery.infra.identity.framework.context.user.mapper;

import br.com.trajy.delivery.infra.identity.framework.context.user.model.CreateUserRequestModel;
import br.com.trajy.delivery.infra.identity.framework.context.user.model.CreateUserResponseModel;
import br.com.trajy.delivery.infra.identity.framework.context.user.model.UserEntity;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.aggregate.UserAggregate;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface UserMapper {

    UserAggregate toDomain(UserEntity entity);

    UserAggregate toDomain(CreateUserRequestModel createRequestModel);

    UserEntity toEntity(UserAggregate entity);

    CreateUserResponseModel toResponse(UserAggregate domain);

}
