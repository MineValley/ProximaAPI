package minevalley.proxima.api;

import minevalley.proxima.api.database.StatementBuilder;
import org.bukkit.plugin.java.JavaPlugin;
import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.sql.SQLException;
import java.util.function.Supplier;

@ApiStatus.Internal
public interface ProximaProvider {

    @Nonnull
    @Contract("_ ,_ -> new")
    StatementBuilder prepareSQL(@Nonnull @Language("SQL") String sql, boolean retrieveGeneratedKeys) throws SQLException;

    @Nonnull
    @Contract(value = "_, _, _ -> new", pure = true)
    String generateUniqueRandomString(@Nonnull String table, @Nonnull String column, @Nonnull Supplier<String> stringSupplier)
            throws IllegalArgumentException, SQLException;

    @Nonnull
    JavaPlugin getInstance();
}