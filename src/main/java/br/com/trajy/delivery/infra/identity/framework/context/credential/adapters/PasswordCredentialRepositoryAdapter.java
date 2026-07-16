package br.com.trajy.delivery.infra.identity.framework.context.credential.adapters;

import br.com.trajy.delivery.infra.identity.framework.context.credential.mapper.PasswordCredentialMapper;
import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.aggregate.PasswordCredential;
import br.com.trajy.delivery.infra.identity.core.context.credential.ports.PasswordCredentialRepositoryPort;
import br.com.trajy.delivery.infra.identity.framework.context.credential.connectors.out.PasswordCredentialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PasswordCredentialRepositoryAdapter implements PasswordCredentialRepositoryPort {

    private final PasswordCredentialRepository repository;
    private final PasswordCredentialMapper mapper;

    @Override
    public PasswordCredential findById(Long id) {
        return this.repository.findById(id).map(this.mapper::toDomain).orElse(null);
    }

    @Override
    public PasswordCredential save(PasswordCredential model) {
        return this.mapper.toDomain(this.repository.save(this.mapper.toEntity(model)));
    }

    @Override
    public PasswordCredential update(PasswordCredential model) {
        return this.mapper.toDomain(this.repository.save(this.mapper.toEntity(model)));
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}
