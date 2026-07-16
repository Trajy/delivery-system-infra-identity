package br.com.trajy.delivery.infra.identity.framework.context.user.model;

public record CreateUserRequestModel(
        String email,
        String password,
        String type
) { }
