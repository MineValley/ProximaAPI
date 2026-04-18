package eu.minevalley.proxima.api.user.event.service.team;

import eu.minevalley.proxima.api.user.ProxyUser;
import eu.minevalley.proxima.api.user.event.ProxyUserEvent;

import javax.annotation.Nonnull;

public abstract class UserUpdateTeamServiceEvent extends ProxyUserEvent {

    public UserUpdateTeamServiceEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}