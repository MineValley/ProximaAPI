package eu.minevalley.proxima.api.user.event.idle;


import eu.minevalley.proxima.api.user.ProxyUser;

import javax.annotation.Nonnull;

/**
 * This event gets called when a proxy user is marked as idle (afk).
 */
@SuppressWarnings("unused")
public class UserEnterIdleStateEvent extends UserUpdateIdleStateEvent {

    public UserEnterIdleStateEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}