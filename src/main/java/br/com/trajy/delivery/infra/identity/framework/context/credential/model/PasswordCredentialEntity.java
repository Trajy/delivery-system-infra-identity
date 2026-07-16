package br.com.trajy.delivery.infra.identity.framework.context.credential.model;


import br.com.trajy.delivery.infra.identity.framework.common.entity.BaseEntity;
import br.com.trajy.delivery.infra.identity.framework.context.user.model.UserEntity;
import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.enums.CredentialStatus;
import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.enums.HashAlgorithmType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class PasswordCredentialEntity extends BaseEntity<Long> {

    private String passwordHash;

    @Enumerated(STRING)
    private HashAlgorithmType hashAlgorithmType;

    @Enumerated(STRING)
    private CredentialStatus status;

    @OneToOne(fetch = LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false, unique = true, foreignKey = @ForeignKey(name = "fk_password_credential_user"))
    private UserEntity user;

}
