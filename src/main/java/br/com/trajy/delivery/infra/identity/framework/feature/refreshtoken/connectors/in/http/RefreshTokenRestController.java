package br.com.trajy.delivery.infra.identity.framework.feature.refreshtoken.connectors.in.http;

import br.com.trajy.delivery.infra.identity.core.feature.refreshtoken.usecase.RefreshTokenUseCase;
import br.com.trajy.delivery.infra.identity.framework.context.refreshtoken.mapper.RefreshTokenMapper;
import br.com.trajy.delivery.infra.identity.framework.context.refreshtoken.model.RefreshTokenRequestModel;
import br.com.trajy.delivery.infra.identity.framework.context.refreshtoken.model.RefreshTokenResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/refresh-tokens")
@RequiredArgsConstructor
public class RefreshTokenRestController {

    private final RefreshTokenMapper mapper;
    private final RefreshTokenUseCase refreshTokenUseCase;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<RefreshTokenResponseModel> refreshToken(@RequestBody RefreshTokenRequestModel requestModel) {
        return ResponseEntity.ok(this.mapper.toResponse(this.refreshTokenUseCase.execute(this.mapper.toInput(requestModel))));
    }

}
