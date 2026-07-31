package br.com.trajy.delivery.infra.identity.framework.context.user.repository;

import br.com.trajy.delivery.infra.identity.framework.context.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
