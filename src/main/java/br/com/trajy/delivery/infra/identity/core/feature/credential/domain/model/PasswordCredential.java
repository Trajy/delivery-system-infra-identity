package br.com.trajy.delivery.infra.identity.core.feature.credential.domain.model;

import br.com.trajy.delivery.infra.identity.core.common.domain.model.BaseDomain;
import br.com.trajy.delivery.infra.identity.core.feature.credential.domain.enums.CredentialStatus;
import br.com.trajy.delivery.infra.identity.core.feature.credential.domain.enums.HashAlgorithmType;
import br.com.trajy.delivery.infra.identity.core.feature.user.domain.model.User;

public class PasswordCredential extends BaseDomain<Long> {

    private User user;
    private String passwordHash;
    private HashAlgorithmType hashAlgorithmType;
    private CredentialStatus status;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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
