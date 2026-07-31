package br.com.trajy.delivery.infra.identity.core.context.refreshtoken.domain.model.aggregate;

import br.com.trajy.delivery.infra.identity.core.common.domain.model.aggregate.BaseUUIDDAggregate;
import br.com.trajy.delivery.infra.identity.core.context.refreshtoken.domain.model.enums.RefreshTokenStatusType;

import java.time.Instant;

public class RefreshTokenAggregate extends BaseUUIDDAggregate {

    private String tokenHash;
    private Instant expiresAt;
    private Instant usedAt;
    private Instant revokedAt;
    private RefreshTokenStatusType status;

    public String getTokenHash() {
        return tokenHash;
    }

    public void setTokenHash(String tokenHash) {
        this.tokenHash = tokenHash;
    }

    public Instant getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Instant expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Instant getUsedAt() {
        return usedAt;
    }

    public void setUsedAt(Instant usedAt) {
        this.usedAt = usedAt;
    }

    public Instant getRevokedAt() {
        return revokedAt;
    }

    public void setRevokedAt(Instant revokedAt) {
        this.revokedAt = revokedAt;
    }

    public RefreshTokenStatusType getStatus() {
        return status;
    }

    public void setStatus(RefreshTokenStatusType status) {
        this.status = status;
    }

}
