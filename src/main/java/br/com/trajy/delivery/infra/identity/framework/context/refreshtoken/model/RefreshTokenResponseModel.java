package br.com.trajy.delivery.infra.identity.framework.context.refreshtoken.model;

import java.time.Instant;

public record RefreshTokenResponseModel(
        String token,
        String refreshToken,
        Instant tokenExpirationDate,
        Instant refreshTokenExpirationDate
) { }
