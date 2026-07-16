package br.com.trajy.delivery.infra.identity.core.feature.credential.interfaces;

import br.com.trajy.delivery.infra.identity.core.feature.credential.domain.enums.HashAlgorithmType;

public interface PasswordEncripter {

    String encrypt(String password);

    HashAlgorithmType getHashAlgorithmType();

}
