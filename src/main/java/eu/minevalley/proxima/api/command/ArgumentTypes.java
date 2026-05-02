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

@SuppressWarnings({"unused", "UnstableApiUsage"})
public interface ArgumentTypes {

    /**
     * Gets an argument type that resolves a single user based on a selector.
     *
     * @return the user selector argument type
     */
    @Nonnull
    @Contract(pure = true)
    ArgumentType<User> user();

    /**
     * Gets an argument type that resolves a group.
     *
     * @return the group argument type
     */
    @Nonnull
    @Contract(pure = true)
    ArgumentType<Group> group();

    /**
     * Gets an argument type that resolves a fraction.
     *
     * @return the fraction argument type
     */
    @Nonnull
    @Contract(pure = true)
    ArgumentType<Fraction> fraction();

    /**
     * Gets an argument type that resolves a team rank.
     *
     * @return the team rank argument type
     */
    @Nonnull
    @Contract(pure = true)
    ArgumentType<TeamRank> teamRank();

    /**
     * Gets an argument type that resolves a server type.
     *
     * @return the server type argument type
     */
    @Nonnull
    @Contract(pure = true)
    ArgumentType<ServerType> server();

    /**
     * Gets an argument type that resolves a block state.
     *
     * @return the block state argument type
     */
    @Nonnull
    @Contract(pure = true)
    ArgumentType<BlockState> blockState();

    /**
     * Gets an argument type that resolves an item stack.
     *
     * @return the item stack argument type
     */
    @Nonnull
    @Contract(pure = true)
    ArgumentType<ItemStack> itemStack();

    /**
     * Gets an argument type that resolves a named text color.
     *
     * @return the named text color argument type
     */
    @Nonnull
    @Contract(pure = true)
    ArgumentType<NamedTextColor> namedColor();

    /**
     * Gets an argument type that resolves a component.
     *
     * @return the component argument type
     */
    @Nonnull
    @Contract(pure = true)
    ArgumentType<Component> component();

    /**
     * Gets an argument type that resolves a game mode.
     *
     * @return the game mode argument type
     */
    @Nonnull
    @Contract(pure = true)
    ArgumentType<GameMode> gameMode();

    /**
     * Gets an argument type that resolves a time in ticks.
     *
     * @return the time argument type
     */
    @Nonnull
    @Contract(pure = true)
    ArgumentType<Integer> time();

    /**
     * Gets an argument type that resolves a time in ticks with a minimum time.
     *
     * @param minTime the minimum time in ticks
     * @return the time argument type
     */
    @Nonnull
    @Contract(pure = true)
    ArgumentType<Integer> time(final int minTime);

    /**
     * Gets an argument type that resolves a block position.
     *
     * @return the block position argument type
     */
    @Nonnull
    @Contract(pure = true)
    ArgumentType<BlockPositionResolver> blockPosition();

    /**
     * Gets an argument type that resolves a fine position.
     *
     * @return the fine position argument type
     */
    @Nonnull
    @Contract(pure = true)
    ArgumentType<FinePositionResolver> finePosition();
}
