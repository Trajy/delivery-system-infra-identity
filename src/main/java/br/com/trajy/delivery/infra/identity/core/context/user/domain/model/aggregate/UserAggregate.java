package br.com.trajy.delivery.infra.identity.core.context.user.domain.model.aggregate;

import br.com.trajy.delivery.infra.identity.core.common.domain.model.aggregate.BaseUUIDDAggregate;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.enums.UserStatus;

public class UserAggregate extends BaseUUIDDAggregate {

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
