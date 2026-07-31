package br.com.trajy.delivery.infra.identity.framework.context.refreshtoken.model;

import br.com.trajy.delivery.infra.identity.core.context.refreshtoken.domain.model.enums.RefreshTokenStatusType;
import br.com.trajy.delivery.infra.identity.framework.common.entity.BaseUUIDEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Getter
@Setter
public class RefreshTokenEntity extends BaseUUIDEntity {

    private String tokenHash;

    private Instant expiresAt;

    private Instant usedAt;

    private Instant revokedAt;

    private RefreshTokenStatusType status;

}
