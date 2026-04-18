package eu.minevalley.proxima.api.user.event.service.team;

import eu.minevalley.proxima.api.user.ProxyUser;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class UserEnterTeamServiceEvent extends UserUpdateTeamServiceEvent {

    public UserEnterTeamServiceEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}