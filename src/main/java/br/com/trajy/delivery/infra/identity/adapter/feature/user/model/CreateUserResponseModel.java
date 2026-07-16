package br.com.trajy.delivery.infra.identity.adapter.feature.user.model;

import br.com.trajy.delivery.infra.identity.core.feature.user.domain.enums.UserStatus;

import java.time.Instant;

public record CreateUserResponseModel(
        Long id,
        String email,
        UserStatus status,
        Instant createdAt,
        Instant updatedAt
) { }
