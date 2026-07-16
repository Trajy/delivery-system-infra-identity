package br.com.trajy.delivery.infra.identity.framework.context.user.adapters;

import br.com.trajy.delivery.infra.identity.framework.context.user.mapper.UserMapper;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.aggregate.User;
import br.com.trajy.delivery.infra.identity.core.context.user.ports.out.UserRepositoryPort;
import br.com.trajy.delivery.infra.identity.framework.context.user.connectors.out.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public User findById(Long id) {
        return this.repository.findById(id).map(this.mapper::toDomain).orElse(null);
    }

    @Override
    public User save(User model) {
        return this.mapper.toDomain(this.repository.save(this.mapper.toEntity(model)));
    }

    @Override
    public User update(User model) {
        return this.mapper.toDomain(this.repository.save(this.mapper.toEntity(model)));
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }

}
