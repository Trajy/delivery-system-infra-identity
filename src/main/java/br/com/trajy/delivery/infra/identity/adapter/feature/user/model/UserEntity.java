package br.com.trajy.delivery.infra.identity.adapter.feature.user.model;

import br.com.trajy.delivery.infra.identity.adapter.common.entity.BaseEntity;
import br.com.trajy.delivery.infra.identity.core.feature.user.domain.enums.UserStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.EnumType.STRING;

@Entity
@Getter
@Setter
public class UserEntity extends BaseEntity<Long> {

    @Column(length = 50, unique = true)
    private String email;

    @Enumerated(STRING)
    private UserStatus status;


}
