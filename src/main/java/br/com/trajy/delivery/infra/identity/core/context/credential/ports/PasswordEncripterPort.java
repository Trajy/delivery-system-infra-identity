package br.com.trajy.delivery.infra.identity.core.context.credential.ports;

import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.enums.HashAlgorithmType;

public interface PasswordEncripterPort {

    String encrypt(String password);

    HashAlgorithmType getHashAlgorithmType();

}
