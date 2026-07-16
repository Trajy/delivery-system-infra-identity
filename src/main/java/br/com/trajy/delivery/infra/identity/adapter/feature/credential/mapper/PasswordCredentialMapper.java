package br.com.trajy.delivery.infra.identity.adapter.feature.credential.mapper;

import br.com.trajy.delivery.infra.identity.adapter.feature.credential.model.PasswordCredentialEntity;
import br.com.trajy.delivery.infra.identity.adapter.feature.user.model.CreateUserRequestModel;
import br.com.trajy.delivery.infra.identity.core.feature.credential.domain.model.PasswordCredential;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface PasswordCredentialMapper {

    PasswordCredential toDomain(PasswordCredentialEntity entity);

    PasswordCredential toDomain(CreateUserRequestModel createRequestModel);

    PasswordCredentialEntity toEntity(PasswordCredential domain);

}
