package br.com.trajy.delivery.infra.identity.core.context.user.domain.model.wrapper.input;

public record CreateUserWithPasswordCredentialWrapperInput(
        String email,
        String password
) { }
