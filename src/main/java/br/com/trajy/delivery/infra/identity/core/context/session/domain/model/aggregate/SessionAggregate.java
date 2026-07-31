package br.com.trajy.delivery.infra.identity.core.context.session.domain.model.aggregate;

import br.com.trajy.delivery.infra.identity.core.common.domain.model.aggregate.BaseUUIDDAggregate;
import br.com.trajy.delivery.infra.identity.core.context.session.domain.model.enums.SessionStatusType;
import br.com.trajy.delivery.infra.identity.core.context.refreshtoken.domain.model.aggregate.RefreshTokenAggregate;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.aggregate.UserAggregate;

import java.time.Instant;
import java.util.List;

public class SessionAggregate extends BaseUUIDDAggregate {

    private Instant expiresAt;
    private Instant lastAccessAt;
    private Instant revokedAt;
    private String userAgent;
    private String ip;
    private SessionStatusType status;
    private List<RefreshTokenAggregate> tokens;
    private UserAggregate user;

    public Instant getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Instant expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Instant getLastAccessAt() {
        return lastAccessAt;
    }

    public void setLastAccessAt(Instant lastAccessAt) {
        this.lastAccessAt = lastAccessAt;
    }

    public Instant getRevokedAt() {
        return revokedAt;
    }

    public void setRevokedAt(Instant revokedAt) {
        this.revokedAt = revokedAt;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public SessionStatusType getStatus() {
        return status;
    }

    public void setStatus(SessionStatusType status) {
        this.status = status;
    }

    public List<RefreshTokenAggregate> getTokens() {
        return tokens;
    }

    public void setTokens(List<RefreshTokenAggregate> tokens) {
        this.tokens = tokens;
    }

    public UserAggregate getUser() {
        return user;
    }

    public void setUser(UserAggregate user) {
        this.user = user;
    }

}
