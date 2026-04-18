package eu.minevalley.proxima.api;

import com.google.gson.Gson;
import eu.minevalley.proxima.api.banking.BankAccount;
import eu.minevalley.proxima.api.corporation.Group;
import eu.minevalley.proxima.api.corporation.company.*;
import eu.minevalley.proxima.api.discord.EmbeddedMessage;
import eu.minevalley.proxima.api.discord.Webhook;
import eu.minevalley.proxima.api.event.EventListener;
import eu.minevalley.proxima.api.gui.FillItem;
import eu.minevalley.proxima.api.gui.InventoryGui;
import eu.minevalley.proxima.api.gui.MultiPageGui;
import eu.minevalley.proxima.api.item.ItemBuilder;
import eu.minevalley.proxima.api.messaging.types.DebugType;
import eu.minevalley.proxima.api.phone.Telephone;
import eu.minevalley.proxima.api.team.Team;
import eu.minevalley.proxima.api.timing.Reminder;
import eu.minevalley.proxima.api.timing.RepeatingTimer;
import eu.minevalley.proxima.api.timing.Timer;
import eu.minevalley.proxima.api.user.User;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.net.URL;
import java.time.DayOfWeek;
import java.util.List;
import java.util.UUID;

@ApiStatus.Internal
public interface ProximaProvider {

    @Nonnull
    @Contract(pure = true)
    JavaPlugin getInstance();

    @Nullable
    @Contract("null -> null")
    User getUser(@Nullable UUID uuid);

    @Nullable
    @Contract("null -> null")
    String getName(@Nullable UUID uniqueId);

    @Nullable
    @Contract("null -> null")
    UUID getUniqueId(@Nullable String name);

    @Nonnull
    @Contract(pure = true)
    Team team();

    void sendDebug(@Nonnull DebugType type, @Nonnull String message);

    @Contract(value = "null -> false", pure = true)
    boolean containsForForbiddenWords(@Nullable String string);

    @Nullable
    @Contract(value = "null -> null", pure = true)
    String convertToTransparent(@Nullable String text);

    @Nullable
    @Contract(value = "null -> null", pure = true)
    Registrant getRegistrant(@Nullable String string);

    @Nonnull
    @Contract(pure = true)
    List<Group> getGroups();

    @Nullable
    @Contract(value = "null -> null", pure = true)
    Group getGroup(String name);

    @Nonnull
    @Contract("_ -> new")
    Einzelunternehmen createEinzelunternehmen(@Nonnull User owner) throws IllegalArgumentException;

    @Nonnull
    @Contract("_, _ -> new")
    Personengesellschaft createPersonengesellschaft(@Nonnull User owner, @Nonnull List<User> coOwners) throws IllegalArgumentException;

    @Nonnull
    @Contract("_ -> new")
    Kapitalgesellschaft createKapitalgesellschaft(int address) throws IllegalArgumentException;

    @Nonnull
    @Contract("_, _ -> new")
    Aktiengesellschaft createAktiengesellschaft(int address, int stocks) throws IllegalArgumentException;

    @Nonnull
    @Contract("_, _ -> new")
    StateCompany createStateCompany(int address, @Nonnull StateCompany.Sector sector) throws IllegalArgumentException;

    @Nonnull
    @Contract(pure = true)
    List<StateCompany> getStateCompanies();

    @Nonnull
    @Contract(pure = true)
    Gson getGson();

    @Contract(pure = true)
    int getRandomInteger(int chars) throws IllegalArgumentException;

    @Contract(value = "null -> false", pure = true)
    boolean isInteger(@Nullable String string);

    @Contract(value = "null -> false", pure = true)
    boolean isDouble(@Nullable String string);

    @Nonnull
    @Contract(pure = true)
    String formatMoney(int amountInCents);

    @Nonnull
    @Contract(pure = true)
    String formatRelativeTimestamp(long time);

    @Nonnull
    @Contract("_ -> new")
    ItemBuilder createItem(@Nonnull ItemStack itemStack) throws IllegalArgumentException;

    @Nonnull
    @Contract("_ -> new")
    ItemBuilder createItem(@Nonnull Material material) throws IllegalArgumentException;

    @Nonnull
    @Contract("_ -> new")
    ItemBuilder createItem(@Nonnull Player player) throws IllegalArgumentException;

    @Nonnull
    @Contract("_ -> new")
    ItemBuilder createItem(@Nonnull UUID uniqueId) throws IllegalArgumentException;

    @Nonnull
    @Contract("_, _ -> new")
    ItemBuilder createItem(@Nonnull String value, @Nonnull String signature) throws IllegalArgumentException;

    @Nonnull
    @Contract("_ -> new")
    ItemBuilder createItem(String url) throws IllegalArgumentException;

    @Nonnull
    @Contract("_, _ -> new")
    InventoryGui createGUI(@Nonnull Component title, @Nonnegative int size) throws IllegalArgumentException;

    @Nonnull
    @Contract("_, _, _ -> new")
    MultiPageGui createMultiPageGui(@Nonnull Component title, @Nonnegative int size, @Nonnull List<FillItem> fillItems) throws IllegalArgumentException;

    @Nullable
    @Contract(value = "null -> null", pure = true)
    BankAccount getBankAccount(@Nullable String iban);

    @Nullable
    @Contract(value = "null -> null", pure = true)
    BankAccount getBankAccount(@Nullable ItemStack bankingCard);

    @Nonnull
    @Contract("_ -> new")
    BankAccount createBankAccount(Registrant holder) throws IllegalArgumentException;

    @Nullable
    @Contract(value = "null -> null", pure = true)
    Telephone getTelephone(@Nullable String telephoneNumber);

    @Nonnull
    @Contract("_, _ -> new")
    Timer startTimer(int delay, @Nonnull Runnable callback) throws IllegalArgumentException;

    @Nonnull
    @Contract("_, _ -> new")
    RepeatingTimer startRepeatingTimer(int period, @Nonnull Runnable callback) throws IllegalArgumentException;

    @Nonnull
    @Contract("_, _, _, _ -> new")
    Reminder createReminder(int hours, int minutes, @Nonnull Runnable callback, DayOfWeek... weekdays)
            throws IllegalArgumentException;

    void registerListener(@Nonnull Class<? extends Event> cls, @Nonnull EventListener<? extends Event> listener)
            throws IllegalArgumentException;

    void unregisterListener(@Nonnull Class<? extends Event> cls, @Nonnull EventListener<? extends Event> listener)
            throws IllegalArgumentException;

    @Nonnull
    @Contract("_ -> new")
    Webhook createWebhook(@Nonnull URL url) throws IllegalArgumentException;

    @Nonnull
    @Contract("-> new")
    EmbeddedMessage createEmbeddedMessage();
}