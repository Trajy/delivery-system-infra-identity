package br.com.trajy.delivery.infra.identity.framework.context.refreshtoken.adapters;

import br.com.trajy.delivery.infra.identity.core.context.refreshtoken.domain.model.aggregate.RefreshTokenAggregate;
import br.com.trajy.delivery.infra.identity.core.context.refreshtoken.ports.TokenRepositoryPort;
import br.com.trajy.delivery.infra.identity.framework.context.refreshtoken.mapper.RefreshTokenMapper;
import br.com.trajy.delivery.infra.identity.framework.context.refreshtoken.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class TokenRepositoryAdapter implements TokenRepositoryPort {

    private final RefreshTokenRepository repository;
    private final RefreshTokenMapper mapper;

    @Override
    public RefreshTokenAggregate findById(UUID id) {
        return this.mapper.toAggregate(this.repository.findById(id).orElse(null));
    }

    @Override
    public RefreshTokenAggregate save(RefreshTokenAggregate aggregate) {
        return this.mapper.toAggregate(this.repository.save(this.mapper.toEntity(aggregate)));
    }

    @Override
    public RefreshTokenAggregate update(RefreshTokenAggregate aggregate) {
        return null;
    }

    @Override
    public void delete(UUID id) {
        this.repository.deleteById(id);
    }

}
