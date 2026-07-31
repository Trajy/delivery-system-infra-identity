package br.com.trajy.delivery.infra.identity.core.common.interfaces;

public interface BaseRepositoryPort<A, I> {

    A findById(I id);

    A save(A aggregate);

    A update(A aggregate);

    void delete(I id);
}
