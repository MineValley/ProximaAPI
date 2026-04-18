package eu.minevalley.proxima.api.user.event.service.support;

import eu.minevalley.proxima.api.user.ProxyUser;
import eu.minevalley.proxima.api.user.event.ProxyUserEvent;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public abstract class UserUpdateSupportServiceEvent extends ProxyUserEvent {

    public UserUpdateSupportServiceEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}