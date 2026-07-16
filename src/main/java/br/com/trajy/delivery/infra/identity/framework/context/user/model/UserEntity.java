package br.com.trajy.delivery.infra.identity.framework.context.user.model;

import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.enums.UserStatus;
import br.com.trajy.delivery.infra.identity.framework.common.entity.BaseUUIDEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.EnumType.STRING;

@Entity
@Getter
@Setter
public class UserEntity extends BaseUUIDEntity {

    @Column(length = 50, unique = true)
    private String email;

    @Enumerated(STRING)
    private UserStatus status;


}
