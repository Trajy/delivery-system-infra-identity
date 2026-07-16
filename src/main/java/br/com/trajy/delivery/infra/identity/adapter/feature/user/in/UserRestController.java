package br.com.trajy.delivery.infra.identity.adapter.feature.user.in;

import br.com.trajy.delivery.infra.identity.adapter.feature.user.mapper.UserMapper;
import br.com.trajy.delivery.infra.identity.adapter.feature.user.model.CreateUserRequestModel;
import br.com.trajy.delivery.infra.identity.adapter.feature.user.model.CreateUserResponseModel;
import br.com.trajy.delivery.infra.identity.core.feature.user.usecase.CreateUserUseCase;
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
    private final CreateUserUseCase createUserUseCase;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateUserResponseModel> createUser(@RequestBody CreateUserRequestModel requestModel) {
        return ResponseEntity.ok(
                this.mapper.toResponse(
                        this.createUserUseCase.execute(
                                this.mapper.toDomain(requestModel)
                        )
                )
        );
    }

}
