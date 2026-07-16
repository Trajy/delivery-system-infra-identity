package br.com.trajy.delivery.infra.identity.framework.context.user.connectors.in;

import br.com.trajy.delivery.infra.identity.framework.context.user.mapper.UserMapper;
import br.com.trajy.delivery.infra.identity.framework.context.user.model.CreateUserRequestModel;
import br.com.trajy.delivery.infra.identity.framework.context.user.model.CreateUserResponseModel;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.wrapper.input.CreateUserWithPasswordCredentialWrapperInput;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.usecase.CreateUserWithPasswordCredentialUseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserRestController {

    private final UserMapper mapper;
    private final CreateUserWithPasswordCredentialUseCase createUserWithPasswordCredentialUseCase;

    @Transactional
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateUserResponseModel> createUser(@RequestBody CreateUserRequestModel requestModel) {
        return ResponseEntity.ok(
                this.mapper.toResponse(
                        this.createUserWithPasswordCredentialUseCase.execute(new CreateUserWithPasswordCredentialWrapperInput(requestModel.email(), requestModel.password()))
                )
        );
    }

}
