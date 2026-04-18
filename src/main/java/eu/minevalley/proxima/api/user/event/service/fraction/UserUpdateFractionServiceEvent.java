package eu.minevalley.proxima.api.user.event.service.fraction;

import eu.minevalley.proxima.api.fraction.Fraction;
import eu.minevalley.proxima.api.user.ProxyUser;
import eu.minevalley.proxima.api.user.event.ProxyUserEvent;
import lombok.Getter;

@Getter
public abstract class UserUpdateFractionServiceEvent extends ProxyUserEvent {

    private final Fraction fractionService;

    public UserUpdateFractionServiceEvent(ProxyUser user, Fraction fractionService) {
        super(user);
        this.fractionService = fractionService;
    }
}