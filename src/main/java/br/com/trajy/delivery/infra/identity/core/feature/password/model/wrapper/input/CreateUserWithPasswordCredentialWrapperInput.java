package br.com.trajy.delivery.infra.identity.core.feature.password.model.wrapper.input;

public record CreateUserWithPasswordCredentialWrapperInput(
        String email,
        String password
) { }
