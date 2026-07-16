package br.com.trajy.delivery.infra.identity.framework.context.user.model;

import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.enums.UserStatus;

import java.time.Instant;

public record CreateUserResponseModel(
        Long id,
        String email,
        UserStatus status,
        Instant createdAt,
        Instant updatedAt
) { }
