package eu.minevalley.proxima.api.command;

import com.mojang.brigadier.arguments.ArgumentType;
import eu.minevalley.proxima.api.corporation.Group;
import eu.minevalley.proxima.api.fraction.Fraction;
import eu.minevalley.proxima.api.server.ServerType;
import eu.minevalley.proxima.api.user.User;
import eu.minevalley.proxima.api.user.team.TeamRank;
import io.papermc.paper.command.brigadier.argument.resolvers.BlockPositionResolver;
import io.papermc.paper.command.brigadier.argument.resolvers.FinePositionResolver;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.GameMode;
import org.bukkit.block.BlockState;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

/**
 * Convenience builder for creating command arguments with short helper methods.
 */
@SuppressWarnings({"unused", "UnstableApiUsage"})
public interface ArgumentBuilder<U extends User> {

    @Nonnull
    @Contract(pure = true)
    CommandArgument<U, User> user(@Nonnull String name);

    @Nonnull
    @Contract(pure = true)
    CommandArgument<U, Group> group(@Nonnull String name);

    @Nonnull
    @Contract(pure = true)
    CommandArgument<U, Fraction> fraction(@Nonnull String name);

    @Nonnull
    @Contract(pure = true)
    CommandArgument<U, TeamRank> teamRank(@Nonnull String name);

    @Nonnull
    @Contract(pure = true)
    CommandArgument<U, ServerType> server(@Nonnull String name);

    @Nonnull
    @Contract(pure = true)
    CommandArgument<U, BlockState> blockState(@Nonnull String name);

    @Nonnull
    @Contract(pure = true)
    CommandArgument<U, ItemStack> itemStack(@Nonnull String name);

    @Nonnull
    @Contract(pure = true)
    CommandArgument<U, NamedTextColor> namedColor(@Nonnull String name);

    @Nonnull
    @Contract(pure = true)
    CommandArgument<U, Component> component(@Nonnull String name);

    @Nonnull
    @Contract(pure = true)
    CommandArgument<U, GameMode> gameMode(@Nonnull String name);

    @Nonnull
    @Contract(pure = true)
    CommandArgument<U, Integer> time(@Nonnull String name);

    @Nonnull
    @Contract(pure = true)
    CommandArgument<U, Integer> time(@Nonnull String name, int minTime);

    @Nonnull
    @Contract(pure = true)
    CommandArgument<U, BlockPositionResolver> blockPosition(@Nonnull String name);

    @Nonnull
    @Contract(pure = true)
    CommandArgument<U, FinePositionResolver> finePosition(@Nonnull String name);

    @Nonnull
    @Contract(pure = true)
    <T> CommandArgument<U, T> custom(@Nonnull String name, @Nonnull ArgumentType<T> type);
}

