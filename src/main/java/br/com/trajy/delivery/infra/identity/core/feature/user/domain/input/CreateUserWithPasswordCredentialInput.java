package br.com.trajy.delivery.infra.identity.core.feature.user.domain.input;

public record CreateUserWithPasswordCredentialInput(
        String email,
        String password
) { }
