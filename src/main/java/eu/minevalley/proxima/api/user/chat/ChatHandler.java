package eu.minevalley.proxima.api.user.chat;

import eu.minevalley.proxima.api.Depends;
import eu.minevalley.proxima.api.user.ProxyUser;

import javax.annotation.Nonnull;

@Depends("ChatLag")
public interface ChatHandler {

    void chat(@Nonnull ProxyUser user, @Nonnull ChatType type, @Nonnull String text) throws IllegalArgumentException;
}
