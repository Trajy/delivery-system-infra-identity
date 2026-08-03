package br.com.trajy.delivery.infra.identity.core.feature.refreshtoken.model.wrapper;

public record RefreshTokenJwtWrapperOutput(
    String token,
    String tokenExpirationTime,
    String refreshToken,
    String refreshTokenExpirationTime
) { }
