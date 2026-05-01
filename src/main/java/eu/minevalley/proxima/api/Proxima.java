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
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public interface Proxima {

    /**
     * Get the {@link Proxy} object, granting access to all proxy-related features.
     *
     * @return Proxy object
     */
    @Nonnull
    @Contract(pure = true)
    Proxy proxy();

    /**
     * Gets the user of with a specific unique id.
     * <br>
     * <strong>Note:</strong> If no user is found, this method returns null.
     *
     * @param uniqueId unique id to get user from
     * @return user object of the given unique id
     */
    @Nullable
    @Contract("null -> null")
    User getUser(@Nullable UUID uniqueId);

    /**
     * Gets the name of the player with the specific unique id.
     * <br>
     * <strong>Note:</strong> If no player is found, this method returns null.
     * <p>
     * <strong>Runtime Optimization</strong>
     * <ul>
     *     <li>This method uses an internal cache</li>
     *     <li>If the player is online, no use of the mojang api is taken</li>
     * </ul>
     * </p>
     *
     * @param uniqueId unique id of the player
     * @return name of the player
     */
    @Nullable
    @Contract("null -> null")
    String getName(@Nullable UUID uniqueId);

    /**
     * Gets the unique id of the player with the specific name.
     * <br>
     * <strong>Note:</strong> If no player is found, this method returns null.
     * <p>
     * <strong>Runtime Optimization</strong>
     *     <ul>
     *         <li>This method uses an internal cache</li>
     *         <li>If the player is online, no use of the mojang api is taken</li>
     * </p>
     *
     * @param name name of the player
     * @return unique id as UUID
     */
    @Nullable
    @Contract("null -> null")
    UUID getUniqueId(@Nullable String name);

    /**
     * The team interface gives you access to all team-related features.
     *
     * @return team interface
     */
    @Nonnull
    @Contract(pure = true)
    Team team();

    /**
     * Sends a debug message to the console and to every online team-member that enabled this debug type.
     *
     * @param type    type of the debug message
     * @param message message as string
     * @throws IllegalArgumentException if the type or message is null
     */
    void sendDebug(@Nonnull DebugType type, @Nonnull String message);

    /**
     * Checks whether the given string contains a forbidden word.
     *
     * @param text text to check
     * @return true, if string contains forbidden words
     */
    @Contract(value = "null -> false", pure = true)
    boolean containsForForbiddenWords(@Nullable String text);

    /**
     * Converts a string to a transparent string.
     *
     * @param text text to convert
     * @return transparent text
     * @throws IllegalArgumentException if the text contains characters that have no transparent representation
     */
    @Nullable
    @Contract(value = "null -> null", pure = true)
    String convertToTransparent(@Nullable String text);

    /**
     * Converts the given hex color code (with or without #) to a decimal color code.
     *
     * @param hex hex color code
     * @return decimal color code
     * @throws IllegalArgumentException if the hex color code is invalid or null
     */
    @Contract(pure = true)
    int convertHexToDecimalColor(@Nonnull String hex) throws IllegalArgumentException;

    /**
     * Gets the registrant object that is represented by the specific string.
     *
     * @param id registrant as string
     * @return represented registrant
     */
    @Nullable
    @Contract(value = "null -> null", pure = true)
    Registrant getRegistrant(@Nullable String id);

    /**
     * Get all groups.
     *
     * @return list of all groups
     */
    @Nonnull
    @Contract(pure = true)
    List<Group> getGroups();

    /**
     * Gets the group (organization/company) with the specific name.
     *
     * @param name name as string
     * @return group with the specific name
     */
    @Nullable
    @Contract(value = "null -> null", pure = true)
    Group getGroup(String name);

    /**
     * Creates a new group of type 'Einzelunternehmen' with the given owner.
     *
     * @param owner owner of this group
     * @return new group
     * @throws IllegalArgumentException if the owner is null or is not allowed to create a group
     */
    @Nonnull
    @Contract("_ -> new")
    Einzelunternehmen createEinzelunternehmen(@Nonnull User owner) throws IllegalArgumentException;

    /**
     * Creates a new group of type 'Personengesellschaft' with the given owner and co-owners.
     *
     * @param owner    owner of this group
     * @param coOwners co-owners of this group
     * @return new group
     * @throws IllegalArgumentException if one of the owners is null or not allowed to create a group
     */
    @Nonnull
    @Contract("_, _ -> new")
    Personengesellschaft createPersonengesellschaft(@Nonnull User owner, @Nonnull List<User> coOwners) throws IllegalArgumentException;

    /**
     * Creates a new group of type 'Kapitalgesellschaft' with the given address.
     *
     * @param address address of this group
     * @return new group
     * @throws IllegalArgumentException if the address cannot be found
     */
    @Nonnull
    @Contract("_ -> new")
    Kapitalgesellschaft createKapitalgesellschaft(int address) throws IllegalArgumentException;

    /**
     * Creates a new group of type 'Aktiengesellschaft' with the given address and stocks.
     *
     * @param address address of this group
     * @param stocks  stocks of this group
     * @return new group
     * @throws IllegalArgumentException if the address cannot be found or stocks is less or equal to 0
     */
    @Nonnull
    @Contract("_, _ -> new")
    Aktiengesellschaft createAktiengesellschaft(int address, int stocks) throws IllegalArgumentException;

    /**
     * Creates a new group of type 'Staat' with the given address.
     *
     * @param address address of this group
     * @return new group
     * @throws IllegalArgumentException if the address cannot be found or the sector is null
     */
    @Nonnull
    @Contract("_, _ -> new")
    StateCompany createStateCompany(int address, @Nonnull StateCompany.Sector sector) throws IllegalArgumentException;

    /**
     * Gets all state companies.
     *
     * @return list of all state companies
     */
    @Nonnull
    @Contract(pure = true)
    List<StateCompany> getStateCompanies();

    /**
     * Gets a pregenerated {@link Gson} instance that fits for pretty printing.
     * Use this to convert json-strings to specific objects and vice versa.
     *
     * @return an instance of Gson configured that fits for pretty printing
     */
    @Nonnull
    @Contract(pure = true)
    Gson getGson();

    /**
     * Gets a random integer with the given length.
     *
     * @param chars number of chars
     * @return random integer
     * @throws IllegalArgumentException if the chars are less than 1
     */
    @Contract(pure = true)
    int getRandomInteger(int chars) throws IllegalArgumentException;

    /**
     * Checks whether the given string is numeric and can be converted to an integer.
     * <p>
     * <b>Note:</b> This method also checks whether the integer exceeds the maximum value for integers.
     *
     * @param string string to verify
     * @return true, if the given string is numeric
     */
    @Contract(value = "null -> false", pure = true)
    boolean isInteger(@Nullable String string);

    /**
     * Verifies that the given string is numeric and can be converted to a double.
     *
     * @param string string to verify
     * @return true, if the given string is numeric
     */
    @Contract(value = "null -> false", pure = true)
    boolean isDouble(@Nullable String string);

    /**
     * Creates a readable string of the specific amount of money.
     *
     * @param amountInCents amount to convert
     * @return amount as x.xxx.xxx,xx€
     */
    @Nonnull
    @Contract(pure = true)
    String formatMoney(int amountInCents);

    /**
     * Formats the given time in a readable way.
     *
     * @param time time in milliseconds to format
     * @return formatted time as dd. MMMM yyyy - HH:mm Uhr
     */
    @Nonnull
    @Contract(pure = true)
    default String getFormattedDate(long time) {
        return new SimpleDateFormat("dd. MMMM yyyy - HH:mm", Locale.GERMANY).format(new Date(time)) + " Uhr";
    }

    /**
     * Formats the given time in a readable way, relative to the current time.
     *
     * @param timestamp time in milliseconds to format
     * @return formatted time as "vor x Sekunden/Minuten/Stunden/Tagen" or "heute, HH:mm Uhr" or "gestern, HH:mm Uhr" or "dd. MMMM yyyy - HH:mm Uhr"
     */
    @Nonnull
    @Contract(pure = true)
    String formatRelativeTimestamp(long timestamp);

    /**
     * Formats the current time in a readable way.
     *
     * @return current time formatted as dd. MMMM yyyy - HH:mm Uhr
     */
    @Nonnull
    @Contract(pure = true)
    default String getCurrentTimeFormatted() {
        return getFormattedDate(System.currentTimeMillis());
    }

    /**
     * Formats the current day in a readable way, without the time.
     *
     * @return current day formatted as dd. MMMM yyyy
     */
    @Nonnull
    @Contract(pure = true)
    default String getCurrentDayTimeFormatted() {
        return getFormattedTime(System.currentTimeMillis());
    }

    /**
     * Formats the given time in a readable way, without the date.
     *
     * @param time time in milliseconds to format
     * @return formatted time as HH:mm Uhr
     */
    @Nonnull
    @Contract(pure = true)
    default String getFormattedTime(long time) {
        return new SimpleDateFormat("HH:mm", Locale.GERMANY).format(new Date(time)) + " Uhr";
    }

    /**
     * Creates a new item-builder based on a specific material.
     *
     * @param itemStack itemstack the item-builder will base on
     * @return new item-builder
     * @throws IllegalArgumentException if the itemstack is null
     */
    @Nonnull
    @Contract("_ -> new")
    ItemBuilder createItem(@Nonnull ItemStack itemStack) throws IllegalArgumentException;

    /**
     * Creates a new item-builder based on a specific material.
     *
     * @param material material of the item to create
     * @return new item-builder
     * @throws IllegalArgumentException if the material is null
     */
    @Nonnull
    @Contract("_ -> new")
    ItemBuilder createItem(@Nonnull Material material) throws IllegalArgumentException;

    /**
     * Creates a new item-builder from the players head.
     *
     * @param player player whose head is wanted
     * @return new item-builder
     * @throws IllegalArgumentException if the player is null
     */
    @Nonnull
    @Contract("_ -> new")
    ItemBuilder createItem(@Nonnull Player player) throws IllegalArgumentException;

    /**
     * Creates a new item-builder from the players head based on its unique id.
     *
     * @param uniqueId unique id of the player whose head is wanted
     * @return new item-builder
     * @throws IllegalArgumentException if the unique id is null or no player is found matching the unique id
     */
    @Nonnull
    @Contract("_ -> new")
    ItemBuilder createItem(@Nonnull UUID uniqueId) throws IllegalArgumentException;

    /**
     * Creates a new item-builder based on the given value and signature.
     *
     * @param value     value of the item
     * @param signature signature of the item
     * @return new item-builder
     * @throws IllegalArgumentException if the value or signature is null or no item could be created based on the given parameters
     */
    @Nonnull
    @Contract("_, _ -> new")
    ItemBuilder createItem(@Nonnull String value, @Nonnull String signature) throws IllegalArgumentException;

    /**
     * Creates new item-builder out of a custom head, based on its link.
     * <p>
     * Example - head from <a href="https://minecraft-heads.com/custom-heads">head-database</a>:
     * The url to the head is:
     * 68c2f1f7e8cd6b00d30f0edaeefce38e889173c30c701fac0da860e0a2125ec8
     * <p>
     * You can use this url to get the head. It doesn't matter whether you're using the whole link (starting with "textures.minecraft.net") or just using the number, as shown above.
     * <p>
     * Note: Always cache heads you already created! Getting/creating new heads can be a waste of server performance. A simple way to cash all heads used in inventories is to load the with the onEnable()-method.
     *
     * @param url link to <span style="text-decoration:underline;">or</span> the id of the specific head
     * @return item-builder based on the chosen head
     * @throws IllegalArgumentException if the url is null
     */
    @Nonnull
    @Contract("_ -> new")
    ItemBuilder createItem(String url) throws IllegalArgumentException;

    /**
     * Creates a gui with a specific size.
     *
     * @param size size of the inventory
     * @return new gui-builder
     * @throws IllegalArgumentException if the size is invalid (negative, higher than 54 or not a multiple of 9 while being higher than 6)
     */
    @Nonnull
    @Contract("_, _ -> new")
    InventoryGui createGUI(@Nonnull Component title, @Nonnegative int size) throws IllegalArgumentException;

    /**
     * Creates a gui with multiple pages and a specific size.
     * <p>
     * The title of the inventory holds two variables:
     * <br>
     * {@code %i%} will be replaced with the current page number
     * <br>
     * {@code %o%} will be replaced with the amount of pages
     *
     * @param title     title of the inventory
     * @param size      size of the inventory
     * @param fillItems items to fill the inventory with
     * @return new gui-builder
     * @throws IllegalArgumentException if the size is invalid (negative, higher than 54 or not a multiple of 9 while being higher than 6)
     */
    @Nonnull
    @Contract("_, _, _ -> new")
    MultiPageGui createMultiPageGui(@Nonnull Component title, @Nonnegative int size, @Nonnull List<FillItem> fillItems) throws IllegalArgumentException;

    /**
     * Gets the bank account with the specific iban.
     *
     * @param iban iban as string
     * @return bank account
     */
    @Nullable
    @Contract(value = "null -> null", pure = true)
    BankAccount getBankAccount(@Nullable String iban);

    /**
     * Gets the bank account with the specific bank card.
     *
     * @param bankCard bank card as itemstack
     * @return bank account
     */
    @Nullable
    @Contract(value = "null -> null", pure = true)
    BankAccount getBankAccount(@Nullable ItemStack bankCard);

    /**
     * Creates a new bank account with the given holder.
     *
     * @param holder holder of this bank account
     * @return new bank account
     * @throws IllegalArgumentException if the holder is null
     */
    @Nonnull
    @Contract("_ -> new")
    BankAccount createBankAccount(Registrant holder) throws IllegalArgumentException;

    /**
     * Gets the telephone with the specific telephone number.
     *
     * @param telephoneNumber telephone number to get telephone from
     * @return telephone with the specific telephone number
     */
    @Nullable
    @Contract(value = "null -> null", pure = true)
    Telephone getTelephone(@Nullable String telephoneNumber);

    /**
     * Starts a timer with the specific parameters.
     *
     * @param delay    delay after which this timer terminates (in minutes)
     * @param callback callback that is called when this timer terminates
     * @return timer with the specific parameters
     * @throws IllegalArgumentException if the delay is less than 1 or the callback is null
     */
    @Nonnull
    @Contract("_, _ -> new")
    Timer startTimer(int delay, @Nonnull Runnable callback) throws IllegalArgumentException;

    /**
     * Starts a repeating timer with the specific parameters.
     * <p>
     * <b>Note:</b> The timer gets triggered immediately after calling this method without having any delay.
     * </p>
     *
     * @param period   period in which this repeating timer is called (in minutes)
     * @param callback callback that is called when this repeating timer reaches a period
     * @return repeating timer with the specific parameters.
     * @throws IllegalArgumentException if the period is less than 1 or the callback is null
     */
    @Nonnull
    @Contract("_, _ -> new")
    RepeatingTimer startRepeatingTimer(int period, @Nonnull Runnable callback) throws IllegalArgumentException;

    /**
     * Creates a reminder with the specific parameters.
     *
     * @param hours    hours on which this reminder is called
     * @param minutes  minutes on which this reminder is called
     * @param callback callback that is called when the given date/time is reached
     * @param weekdays weekdays on which this reminder is active
     * @return reminder with the specific parameters.
     * @throws IllegalArgumentException if the hours or minutes are invalid
     */
    @Nonnull
    @Contract("_, _, _, _ -> new")
    Reminder createReminder(int hours, int minutes, @Nonnull Runnable callback, DayOfWeek... weekdays)
            throws IllegalArgumentException;

    /**
     * Creates a reminder with the specific parameters.
     *
     * @param hours    hours on which this reminder is called
     * @param minutes  minutes on which this reminder is called
     * @param callback callback that is called when the given date/time is reached
     * @return reminder with the specific parameters.
     * @throws IllegalArgumentException if the hours or minutes are invalid or the callback is null
     */
    @Nonnull
    @Contract("_, _, _ -> new")
    default Reminder createReminder(@Nonnegative int hours, @Nonnegative int minutes, @Nonnull Runnable callback)
            throws IllegalArgumentException {
        return createReminder(hours, minutes, callback, DayOfWeek.values());
    }

    /**
     * Registers an event listener.
     *
     * @param cls      class of the event
     * @param listener listener to register
     * @throws IllegalArgumentException if the event class or listener is null
     */
    void registerListener(@Nonnull Class<? extends Event> cls, @Nonnull EventListener<? extends Event> listener)
            throws IllegalArgumentException;

    /**
     * Unregisters an event listener.
     *
     * @param cls      class of the event
     * @param listener listener to unregister
     * @throws IllegalArgumentException if the event class or listener is null
     */
    void unregisterListener(@Nonnull Class<? extends Event> cls, @Nonnull EventListener<? extends Event> listener)
            throws IllegalArgumentException;

    /**
     * Creates a new Discord Webhook.
     *
     * @param url URL of Webhook
     * @return Webhook with given URL
     * @throws IllegalArgumentException if the URL is null
     */
    @Nonnull
    @Contract("_ -> new")
    Webhook createWebhook(@Nonnull URL url) throws IllegalArgumentException;

    /**
     * Creates an embedded message to be sent via webhook
     *
     * @return embedded message
     */
    @Nonnull
    @Contract("-> new")
    EmbeddedMessage createEmbeddedMessage();
}