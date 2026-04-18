package eu.minevalley.proxima.api.user.event.service.fraction;

import eu.minevalley.proxima.api.fraction.Fraction;
import eu.minevalley.proxima.api.user.ProxyUser;

import javax.annotation.Nonnull;

/**
 * This event is called when a user is requested to enter a fraction service, before the action is processed.
 */
@SuppressWarnings("unused")
public class UserPreEnterFractionServiceEvent extends UserUpdateFractionServiceEvent {

    public UserPreEnterFractionServiceEvent(@Nonnull ProxyUser user, @Nonnull Fraction fractionService) {
        super(user, fractionService);
    }
}