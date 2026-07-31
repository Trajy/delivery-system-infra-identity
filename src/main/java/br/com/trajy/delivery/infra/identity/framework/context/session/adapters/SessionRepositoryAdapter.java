package br.com.trajy.delivery.infra.identity.framework.context.session.adapters;

import br.com.trajy.delivery.infra.identity.core.context.session.domain.model.aggregate.SessionAggregate;
import br.com.trajy.delivery.infra.identity.core.context.session.ports.SessionRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SessionRepositoryAdapter implements SessionRepositoryPort {

    @Override
    public SessionAggregate findById(UUID id) {
        //TODO - Implement findById
        return null;
    }

    @Override
    public SessionAggregate save(SessionAggregate model) {
        //TODO - implement save
        return null;
    }

    @Override
    public SessionAggregate update(SessionAggregate model) {
        //TODO - implement update
        return null;
    }

    @Override
    public void delete(UUID id) {
        //TODO - implement delete
    }

}
