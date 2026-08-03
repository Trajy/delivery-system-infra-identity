package br.com.trajy.delivery.infra.identity.core.feature.password.model.wrapper.input;

import br.com.trajy.delivery.infra.identity.core.context.refreshtoken.domain.model.enums.EncryptionType;

public record LoginWithPasswordCredentialWrapperInput(
    String identifier,
    String password,
    EncryptionType encryptionType
) { }
