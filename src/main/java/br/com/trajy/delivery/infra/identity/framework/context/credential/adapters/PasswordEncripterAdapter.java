package br.com.trajy.delivery.infra.identity.framework.context.credential.adapters;

import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.enums.HashAlgorithmType;
import br.com.trajy.delivery.infra.identity.core.context.credential.ports.PasswordEncripterPort;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncripterAdapter implements PasswordEncripterPort {

    @Override
    public String encrypt(String password) {
        return "";
    }

    @Override
    public HashAlgorithmType getHashAlgorithmType() {
        return null;
    }
}
