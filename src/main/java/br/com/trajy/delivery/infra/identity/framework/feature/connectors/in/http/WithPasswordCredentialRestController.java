package br.com.trajy.delivery.infra.identity.framework.feature.connectors.in.http;

import br.com.trajy.delivery.infra.identity.core.usecase.password.CreateWithPasswordCredentialUseCase;
import br.com.trajy.delivery.infra.identity.core.usecase.password.LoginWithPasswordCredentialUseCase;
import br.com.trajy.delivery.infra.identity.framework.context.user.mapper.UserWithPasswordCredentialMapper;
import br.com.trajy.delivery.infra.identity.framework.context.user.model.CreateUserWithPasswordCredentialRequestModel;
import br.com.trajy.delivery.infra.identity.framework.context.user.model.LoginWithPasswordCredentialRequestModel;
import br.com.trajy.delivery.infra.identity.framework.context.user.model.LoginWithPasswordCredentialResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/users/passwords")
@RequiredArgsConstructor
public class WithPasswordCredentialRestController {

    private final UserWithPasswordCredentialMapper mapper;
    private final CreateWithPasswordCredentialUseCase createWithPasswordCredentialUseCase;
    private final LoginWithPasswordCredentialUseCase loginWithPasswordCredentialUseCase;

    @PostMapping(path = "/registrations", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createUser(@RequestBody CreateUserWithPasswordCredentialRequestModel requestModel) {
        this.createWithPasswordCredentialUseCase.execute(this.mapper.toInput(requestModel));
        return ok().build();
    }

    @PostMapping(path = "/logins", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<LoginWithPasswordCredentialResponseModel> login(@RequestBody LoginWithPasswordCredentialRequestModel requestModel) {
        return ok(
                this.mapper.toResponse(
                        this.loginWithPasswordCredentialUseCase.execute(
                               this.mapper.toInput(requestModel)
                        )
                )
        );
    }


}
