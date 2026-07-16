package br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.aggregate;

import br.com.trajy.delivery.infra.identity.core.common.domain.model.aggregate.BaseUUIDDAggregate;
import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.enums.CredentialStatus;
import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.enums.HashAlgorithmType;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.aggregate.UserAggregate;

public class PasswordCredentialAggregate extends BaseUUIDDAggregate {

    private UserAggregate user;
    private String passwordHash;
    private HashAlgorithmType hashAlgorithmType;
    private CredentialStatus status;

    public UserAggregate getUser() {
        return user;
    }

    public void setUser(UserAggregate user) {
        this.user = user;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public HashAlgorithmType getHashAlgorithmType() {
        return hashAlgorithmType;
    }

    public void setHashAlgorithmType(HashAlgorithmType hashAlgorithmType) {
        this.hashAlgorithmType = hashAlgorithmType;
    }

    public CredentialStatus getStatus() {
        return status;
    }

    public void setStatus(CredentialStatus status) {
        this.status = status;
    }

}
