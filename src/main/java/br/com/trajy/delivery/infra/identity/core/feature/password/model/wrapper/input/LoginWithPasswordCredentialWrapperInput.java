package br.com.trajy.delivery.infra.identity.core.feature.password.model.wrapper.input;

import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.enums.HashAlgorithmType;
import br.com.trajy.delivery.infra.identity.core.context.refreshtoken.domain.model.enums.EncryptionType;

public record LoginWithPasswordCredentialWrapperInput(
    String identifier,
    String password,
    HashAlgorithmType hashAlgorithmType,
    EncryptionType encryptionType
) { }
