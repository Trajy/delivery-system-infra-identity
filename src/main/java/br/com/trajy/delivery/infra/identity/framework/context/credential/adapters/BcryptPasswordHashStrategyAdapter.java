package br.com.trajy.delivery.infra.identity.framework.context.credential.adapters;

import br.com.trajy.delivery.infra.identity.core.context.credential.annotation.HashAlgorithm;
import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.aggregate.PasswordCredentialAggregate;
import br.com.trajy.delivery.infra.identity.core.context.credential.ports.PasswordHashStrategyPort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import static br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.enums.HashAlgorithmType.BCRYPT;

@HashAlgorithm(BCRYPT)
@Component
public class BcryptPasswordHashStrategyAdapter implements PasswordHashStrategyPort {

    private final BCryptPasswordEncoder passwordEncoder;

    public BcryptPasswordHashStrategyAdapter(@Value("${security.password.hash.bcrypt.cost:12}") int cost) {
        this.passwordEncoder = new BCryptPasswordEncoder(cost);
    }

    @Override
    public PasswordCredentialAggregate createPasswordCredentialAggregate(String password) {
        final PasswordCredentialAggregate aggregate = new PasswordCredentialAggregate();
        aggregate.setPasswordHash(this.passwordEncoder.encode(password));
        return aggregate;
    }

    @Override
    public Boolean matches(String password, PasswordCredentialAggregate passwordCredentialAggregate) {
        return this.passwordEncoder.matches(password, passwordCredentialAggregate.getPasswordHash());
    }

}
