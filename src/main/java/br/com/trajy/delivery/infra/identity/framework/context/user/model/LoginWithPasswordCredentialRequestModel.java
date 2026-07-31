package br.com.trajy.delivery.infra.identity.framework.context.user.model;

public record LoginWithPasswordCredentialRequestModel(
        String identifier,
        String password
) { }
