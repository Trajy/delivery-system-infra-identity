package br.com.trajy.delivery.infra.identity.core.feature.password.model.wrapper.input;

import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.enums.HashAlgorithmType;

import static java.util.Objects.isNull;

public record CreateWithPasswordCredentialWrapperInput(
        String email,
        String password,
        HashAlgorithmType hashAlgorithmType
) {

    public CreateWithPasswordCredentialWrapperInput {
        if(isNull(hashAlgorithmType)) {
            hashAlgorithmType = HashAlgorithmType.BCRYPT;
        }
    }

}
