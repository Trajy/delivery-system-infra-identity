package br.com.trajy.delivery.infra.identity.framework.context.user.model;

public record CreateUserWithPasswordCredentialRequestModel(
        String email,
        String password
) { }
