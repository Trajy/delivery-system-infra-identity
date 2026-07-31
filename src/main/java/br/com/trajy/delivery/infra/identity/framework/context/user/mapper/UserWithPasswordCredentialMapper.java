package br.com.trajy.delivery.infra.identity.framework.context.user.mapper;

import br.com.trajy.delivery.infra.identity.core.context.session.domain.model.aggregate.SessionAggregate;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.aggregate.UserAggregate;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.wrapper.input.CreateUserWithPasswordCredentialWrapperInput;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.wrapper.input.LoginWithPasswordCredentialWrapperInput;
import br.com.trajy.delivery.infra.identity.framework.context.user.model.CreateUserWithPasswordCredentialRequestModel;
import br.com.trajy.delivery.infra.identity.framework.context.user.model.LoginWithPasswordCredentialRequestModel;
import br.com.trajy.delivery.infra.identity.framework.context.user.model.LoginWithPasswordCredentialResponseModel;
import br.com.trajy.delivery.infra.identity.framework.context.user.model.UserEntity;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface UserWithPasswordCredentialMapper {

    UserAggregate toDomain(UserEntity entity);

    UserEntity toEntity(UserAggregate aggregate);

    CreateUserWithPasswordCredentialWrapperInput toInput(CreateUserWithPasswordCredentialRequestModel requestModel);

    LoginWithPasswordCredentialWrapperInput toInput(LoginWithPasswordCredentialRequestModel requestModel);

    LoginWithPasswordCredentialResponseModel toResponse(SessionAggregate aggregate);

}
