package br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.aggregate;

import br.com.trajy.delivery.infra.identity.core.common.domain.model.aggregate.BaseUUIDDAggregate;
import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.enums.CredentialStatus;
import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.enums.HashAlgorithmType;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.aggregate.UserAggregate;

import java.time.Instant;

public class PasswordCredentialAggregate extends BaseUUIDDAggregate {

    private UserAggregate user;
    private String passwordHash;
    private String passwordRefreshHash;
    private Instant passwordHashExpiresAt;
    private Instant passwordRefreshHashExpiresAt;
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

    public Instant getPasswordHashExpiresAt() {
        return passwordHashExpiresAt;
    }

    public void setPasswordHashExpiresAt(Instant passwordHashExpiresAt) {
        this.passwordHashExpiresAt = passwordHashExpiresAt;
    }

    public String getPasswordRefreshHash() {
        return passwordRefreshHash;
    }

    public void setPasswordRefreshHash(String passwordRefreshHash) {
        this.passwordRefreshHash = passwordRefreshHash;
    }

    public Instant getPasswordRefreshHashExpiresAt() {
        return passwordRefreshHashExpiresAt;
    }

    public void setPasswordRefreshHashExpiresAt(Instant passwordRefreshHashExpiresAt) {
        this.passwordRefreshHashExpiresAt = passwordRefreshHashExpiresAt;
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
