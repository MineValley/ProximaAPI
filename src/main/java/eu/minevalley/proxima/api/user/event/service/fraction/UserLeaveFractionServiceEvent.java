package eu.minevalley.proxima.api.user.event.service.fraction;

import eu.minevalley.proxima.api.fraction.Fraction;
import eu.minevalley.proxima.api.user.ProxyUser;
import lombok.Getter;

import javax.annotation.Nonnull;

@Getter
@SuppressWarnings("unused")
public class UserLeaveFractionServiceEvent extends UserUpdateFractionServiceEvent {

    public UserLeaveFractionServiceEvent(@Nonnull ProxyUser user, Fraction fractionService) {
        super(user, fractionService);
    }
}