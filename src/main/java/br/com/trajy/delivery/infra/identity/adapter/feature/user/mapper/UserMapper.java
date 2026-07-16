package br.com.trajy.delivery.infra.identity.adapter.feature.user.mapper;

import br.com.trajy.delivery.infra.identity.adapter.feature.user.model.CreateUserRequestModel;
import br.com.trajy.delivery.infra.identity.adapter.feature.user.model.CreateUserResponseModel;
import br.com.trajy.delivery.infra.identity.adapter.feature.user.model.UserEntity;
import br.com.trajy.delivery.infra.identity.core.feature.user.domain.model.User;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface UserMapper {

    User toDomain(UserEntity entity);

    User toDomain(CreateUserRequestModel createRequestModel);

    UserEntity toEntity(User entity);

    CreateUserResponseModel toResponse(User domain);

}
