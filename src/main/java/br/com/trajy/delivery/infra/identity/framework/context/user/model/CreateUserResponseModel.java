package br.com.trajy.delivery.infra.identity.framework.context.user.model;

import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.enums.UserStatus;

import java.time.Instant;
import java.util.UUID;

public record CreateUserResponseModel(
        UUID id,
        String email,
        UserStatus status,
        Instant createdAt,
        Instant updatedAt
) { }
