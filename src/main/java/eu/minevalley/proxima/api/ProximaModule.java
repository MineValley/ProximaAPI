package eu.minevalley.proxima.api;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
@RequiredArgsConstructor
public abstract class ProximaModule {

    private final @Nonnull Proxima proxima;

    /**
     * Gets this modules instance of the {@link Proxima}.
     *
     * @return this modules instance of the ProximaAPI
     */
    @Nonnull
    @Contract(pure = true)
    public final Proxima proxima() {
        return proxima;
    }

    /**
     * Is called when the module is enabled.
     */
    public void onEnable() {
        // override this method to add logic
    }

    /**
     * Is called when the module is disabled.
     */
    public void onDisable() {
        // override this method to add logic
    }

    /**
     * Is called then the server starts with the cleanup flag.
     */
    public void onCleanup() {
        // override this method to add logic
    }

    /**
     * Gets the version of this module.
     *
     * @return the version
     */
    @Nonnull
    @Contract(pure = true)
    public final String getVersion() {
        return proxima.getVersion(this);
    }

    /**
     * Gets an array of this module's developers, as to find in the {@code pom.xml}.
     *
     * @return array of developers
     */
    @Nonnull
    @Contract(pure = true)
    public final Developer[] getDevelopers() {
        return proxima.getDevelopers(this);
    }
}