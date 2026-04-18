package eu.minevalley.proxima.api.user.event;

import eu.minevalley.proxima.api.event.ProxyEvent;
import eu.minevalley.proxima.api.user.ProxyUser;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.annotation.Nonnull;

@RequiredArgsConstructor
public abstract class ProxyUserEvent extends ProxyEvent {

    private final @Getter(onMethod_ = @Nonnull) ProxyUser user;
}