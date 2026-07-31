package br.com.trajy.delivery.infra.identity.framework.context.user.adapters;

import br.com.trajy.delivery.infra.identity.framework.context.user.mapper.UserWithPasswordCredentialMapper;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.aggregate.UserAggregate;
import br.com.trajy.delivery.infra.identity.core.context.user.ports.UserRepositoryPort;
import br.com.trajy.delivery.infra.identity.framework.context.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final UserRepository repository;
    private final UserWithPasswordCredentialMapper mapper;

    @Override
    public UserAggregate findById(Long id) {
        return this.repository.findById(id).map(this.mapper::toDomain).orElse(null);
    }

    @Override
    public UserAggregate save(UserAggregate aggregate) {
        return this.mapper.toDomain(this.repository.save(this.mapper.toEntity(aggregate)));
    }

    @Override
    public UserAggregate update(UserAggregate aggregate) {
        return this.mapper.toDomain(this.repository.save(this.mapper.toEntity(aggregate)));
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public UserAggregate findByUniqueFields(String email) {
        //TODO - Implement findByUniqueFields method
        return null;
    }

    @Override
    public UserAggregate findByIdentifier(String identifier) {
        //TODO - Implement findByIdentifier method
        return null;
    }

}
