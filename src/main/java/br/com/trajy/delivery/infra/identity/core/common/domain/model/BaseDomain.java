package br.com.trajy.delivery.infra.identity.core.common.domain.model;

import java.time.Instant;

public abstract class BaseDomain<T> {

    private T id;

    private Instant createdAt;

    private Instant updatedAt;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

}
