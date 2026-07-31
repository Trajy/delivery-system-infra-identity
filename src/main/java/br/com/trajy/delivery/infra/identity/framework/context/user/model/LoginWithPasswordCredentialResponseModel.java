package br.com.trajy.delivery.infra.identity.framework.context.user.model;

import java.time.Instant;

public record LoginWithPasswordCredentialResponseModel(
        String token,
        String refreshToken,
        Instant tokenExpirationDate,
        Instant refreshTokenExpirationDate
) { }
