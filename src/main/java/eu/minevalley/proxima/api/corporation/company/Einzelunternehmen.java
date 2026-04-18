package eu.minevalley.proxima.api.corporation.company;

import eu.minevalley.proxima.api.corporation.Group;
import eu.minevalley.proxima.api.user.User;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface Einzelunternehmen extends Group {

    /**
     * Gets the owner of this Einzelunternehmen.
     *
     * @return the owner
     */
    @Nonnull
    @Contract(pure = true)
    User getOwner();
}
