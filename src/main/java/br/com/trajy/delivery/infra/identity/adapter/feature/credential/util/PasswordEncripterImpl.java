package br.com.trajy.delivery.infra.identity.adapter.feature.credential.util;

import br.com.trajy.delivery.infra.identity.core.feature.credential.domain.enums.HashAlgorithmType;
import br.com.trajy.delivery.infra.identity.core.feature.credential.interfaces.PasswordEncripter;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncripterImpl implements PasswordEncripter {

    @Override
    public String encrypt(String password) {
        return "";
    }

    @Override
    public HashAlgorithmType getHashAlgorithmType() {
        return null;
    }
}
