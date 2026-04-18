package eu.minevalley.proxima.api;

import javax.annotation.Nonnull;

public record Developer(@Nonnull String name, @Nonnull String uuid, @Nonnull String discord) {
}
