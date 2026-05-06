package eu.minevalley.proxima.api.command;

import com.mojang.brigadier.arguments.ArgumentType;
import eu.minevalley.proxima.api.user.User;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

/**
 * A utility class for creating commands.
 */
@SuppressWarnings("unused")
public interface Command<U extends User> {

    /**
     * @param name the name of the (sub-) command
     * @return a {@link CommandLiteral} object representing the (sub-) command
     * @throws IllegalArgumentException if the name is null or empty
     */
    @Nonnull
    @Contract(pure = true)
    CommandLiteral<U> literal(@Nonnull String name) throws IllegalArgumentException;

    /**
     * Convenience entry point to create arguments using short helper methods, e.g.
     * command.argument().onlineUser("spieler");
     *
     * Implementations should return an {@link eu.minevalley.proxima.api.command.ArgumentBuilder} backed
     * by their {@link eu.minevalley.proxima.api.command.ArgumentTypes} provider.
     *
     * Note: this method is intentionally abstract to force implementors to provide the
     * ArgumentTypes instance (implementation-specific).
     */
    @Nonnull
    @Contract(pure = true)
    ArgumentBuilder<U> argument();
}
