package br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.factory;

import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.aggregate.PasswordCredentialAggregate;
import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.enums.HashAlgorithmType;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.aggregate.UserAggregate;

import java.time.Instant;

import static br.com.trajy.delivery.infra.identity.core.common.exception.type.UnsupportedInstantiationException.utilityClassUnsupportedInstantiationException;
import static br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.enums.CredentialStatus.ACTIVE;

public final class PasswordCredentialFactory {

    private PasswordCredentialFactory() {
        utilityClassUnsupportedInstantiationException();
    }

    public static PasswordCredentialAggregate createCredential(
            UserAggregate user,
            String passwordHash,
            String passwordRefreshHash,
            Instant passwordHashExpiration,
            Instant passwordRefreshHashExpiration,
            HashAlgorithmType hashAlgorithmType
    ) {
        final PasswordCredentialAggregate model = new PasswordCredentialAggregate();
        model.setUser(user);
        model.setPasswordHash(passwordHash);
        model.setPasswordHashExpiresAt(passwordHashExpiration);
        model.setPasswordRefreshHashExpiresAt(passwordRefreshHashExpiration);
        model.setPasswordRefreshHash(passwordRefreshHash);
        model.setHashAlgorithmType(hashAlgorithmType);
        model.setStatus(ACTIVE);
        return model;
    }

}
