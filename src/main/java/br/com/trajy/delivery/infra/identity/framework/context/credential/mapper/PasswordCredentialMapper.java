package br.com.trajy.delivery.infra.identity.framework.context.credential.mapper;

import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.aggregate.PasswordCredentialAggregate;
import br.com.trajy.delivery.infra.identity.framework.context.credential.model.PasswordCredentialEntity;
import br.com.trajy.delivery.infra.identity.framework.context.user.model.CreateUserRequestModel;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface PasswordCredentialMapper {

    PasswordCredentialAggregate toDomain(PasswordCredentialEntity entity);

    PasswordCredentialAggregate toDomain(CreateUserRequestModel createRequestModel);

    PasswordCredentialEntity toEntity(PasswordCredentialAggregate domain);

}
