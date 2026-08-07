package br.com.trajy.delivery.infra.identity.framework.context.user.model;

import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.enums.HashAlgorithmType;

public record CreateUserWithPasswordCredentialRequestModel(
        String email,
        String password,
        HashAlgorithmType hashAlgorithmType
) { }
