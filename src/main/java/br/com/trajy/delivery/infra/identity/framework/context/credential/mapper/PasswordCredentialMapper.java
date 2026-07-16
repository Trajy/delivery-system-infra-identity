package br.com.trajy.delivery.infra.identity.framework.context.credential.mapper;

import br.com.trajy.delivery.infra.identity.framework.context.credential.model.PasswordCredentialEntity;
import br.com.trajy.delivery.infra.identity.framework.context.user.model.CreateUserRequestModel;
import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.aggregate.PasswordCredential;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface PasswordCredentialMapper {

    PasswordCredential toDomain(PasswordCredentialEntity entity);

    PasswordCredential toDomain(CreateUserRequestModel createRequestModel);

    PasswordCredentialEntity toEntity(PasswordCredential domain);

}
