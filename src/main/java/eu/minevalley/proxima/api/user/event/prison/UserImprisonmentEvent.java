package eu.minevalley.proxima.api.user.event.prison;

import eu.minevalley.proxima.api.user.ProxyUser;

import javax.annotation.Nonnull;

/**
 * This event gets called when a user is getting imprisoned.
 */
@SuppressWarnings("unused")
public class UserImprisonmentEvent extends UserUpdatePrisonStateEvent {

    public UserImprisonmentEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}