package eu.minevalley.proxima.api.user.event.service.team;

import eu.minevalley.proxima.api.user.ProxyUser;

import javax.annotation.Nonnull;

/**
 * This event is called when a user is requested to leave the team service, before the action is processed.
 */
@SuppressWarnings("unused")
public class UserPreLeaveTeamServiceEvent extends UserUpdateTeamServiceEvent {

    public UserPreLeaveTeamServiceEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}