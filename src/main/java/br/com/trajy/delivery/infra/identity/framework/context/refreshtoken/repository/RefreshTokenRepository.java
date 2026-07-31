package br.com.trajy.delivery.infra.identity.framework.context.refreshtoken.repository;

import br.com.trajy.delivery.infra.identity.framework.context.refreshtoken.model.RefreshTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshTokenEntity, UUID> {

}
