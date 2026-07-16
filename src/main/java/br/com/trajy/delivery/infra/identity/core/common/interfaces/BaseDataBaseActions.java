package br.com.trajy.delivery.infra.identity.core.common.interfaces;

public interface BaseDataBaseActions<T, I> {

    T findById(I id);

    T save(T model);

    T update(T model);

    void delete(I id);
}
