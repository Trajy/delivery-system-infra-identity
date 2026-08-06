package br.com.trajy.delivery.infra.identity.core.context.refreshtoken.domain.model.wrapper;

public class RefreshTokenEncryptionOutput {

    private final String token;
    private final String tokenExpirationTime;
    private final String refreshToken;
    private final String refreshTokenExpirationTime;

    public RefreshTokenEncryptionOutput(String token, String tokenExpirationTime, String refreshToken, String refreshTokenExpirationTime) {
        this.token = token;
        this.tokenExpirationTime = tokenExpirationTime;
        this.refreshToken = refreshToken;
        this.refreshTokenExpirationTime = refreshTokenExpirationTime;
    }

    public String getToken() {
        return token;
    }

    public String getTokenExpirationTime() {
        return tokenExpirationTime;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public String getRefreshTokenExpirationTime() {
        return refreshTokenExpirationTime;
    }
}
