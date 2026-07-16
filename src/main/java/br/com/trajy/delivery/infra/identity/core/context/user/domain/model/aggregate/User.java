package br.com.trajy.delivery.infra.identity.core.context.user.domain.model.aggregate;

import br.com.trajy.delivery.infra.identity.core.common.domain.model.BaseDomain;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.enums.UserStatus;

public class User extends BaseDomain<Long> {

    private String email;
    private UserStatus status;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }
    
}
