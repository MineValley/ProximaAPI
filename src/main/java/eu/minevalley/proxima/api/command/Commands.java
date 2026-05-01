package eu.minevalley.proxima.api.command;

import com.mojang.brigadier.arguments.ArgumentType;
import eu.minevalley.proxima.api.user.User;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

/**
 * A utility class for creating commands.
 */
@SuppressWarnings("unused")
public interface Commands<U extends User> {

    /**
     * @param name the name of the (sub-) command
     * @return a {@link CommandLiteral} object representing the (sub-) command
     * @throws IllegalArgumentException if the name is null or empty
     */
    @Nonnull
    @Contract(pure = true)
    CommandLiteral<U> literal(@Nonnull String name) throws IllegalArgumentException;

    /**
     * Creates a new command argument.
     *
     * @param name the name of the argument
     * @param type the type of the argument
     * @param <T>  the class of the argument
     * @return a {@link CommandArgument} object representing the argument
     * @throws IllegalArgumentException if the name is null or empty, or if the type is null
     */
    @Nonnull
    @Contract(pure = true)
    <T> CommandArgument<U, T> argument(@Nonnull String name, @Nonnull ArgumentType<T> type) throws IllegalArgumentException;
}
