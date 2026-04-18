package eu.minevalley.proxima.api;

import eu.minevalley.proxima.api.banking.AccountUser;
import eu.minevalley.proxima.api.banking.BankAccount;
import eu.minevalley.proxima.api.corporation.company.Aktiengesellschaft;
import eu.minevalley.proxima.api.corporation.company.Kapitalgesellschaft;
import eu.minevalley.proxima.api.localization.Address;
import eu.minevalley.proxima.api.user.User;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Set;

@SuppressWarnings("unused")
public interface Registrant {

    @Nonnull
    @Contract(pure = true)
    String getId();

    /**
     * Gets the name to display on signs etc.
     * <p>
     * <b>Department:</b> "name of department - name of company/association"
     * <p>
     * <b>Note:</b> department names may be longer than 16 characters and can therefore not been put onto signs!
     *
     * @return this registrants name as string.
     */
    @Nonnull
    @Contract(pure = true)
    String getName();

    /**
     * Takes the registrant's name, but truncates it if it's longer than 16 characters.
     *
     * @return this registrants name cropped to have a maximum length of 16 characters.
     */
    @Nonnull
    @Contract(pure = true)
    default String getCroppedName() {
        final String name = getName();
        if (name.length() <= 16) return name;
        return name.substring(0, 13) + "...";
    }

    /**
     * Checks whether a user is represented by this registrant (in case it represents only one user),
     * or whether the user is part of the group / department, that this registrant represents.
     *
     * @param user user to check
     * @return true, if the user is represented by this registrant or is a part of the group / department that this registrant represents
     */
    @Contract(value = "null -> false", pure = true)
    boolean contains(@Nullable User user);

    /**
     * Gets a set of all users that belong to this registrant.
     * If this registrant is a user, the set will only contain that user.
     * If this registrant is a group or department, the set will contain all users that are part of that group or department.
     *
     * @return set of related users
     */
    @Nonnull
    @Contract(pure = true)
    Set<User> getUsers();

    /**
     * Gets the address of this registrant.
     * If this registrant is a department without its own address, this will return the groups address.
     * If this registrant is a group without its own address, this will return the address of the owner.
     *
     * @return this registrants address as residence
     */
    @Nullable
    @Contract(pure = true)
    Address getAddress();

    /**
     * Gets the bank account that is associated with this registrant.
     * Departments may not have their own bank account. If this registrant is a department without its own bank account,
     * this method will return the bank account of the department's company/organization.
     *
     * @return the bank account that is associated with this registrant.
     */
    @Nonnull
    @Contract(pure = true)
    BankAccount getBankAccount();

    /**
     * Gets a set of all related bank account users.
     *
     * @return set of all related bank account users.
     */
    @Nonnull
    @Contract(pure = true)
    Set<AccountUser> getRelatedAccountUsers();

    /**
     * Gets a set of all related stockholders.
     *
     * @return set of all related stockholders
     */
    @Nonnull
    @Contract(pure = true)
    Set<Aktiengesellschaft.Stockholder> getRelatedStockholders();

    /**
     * Gets a set of all related shareholders.
     *
     * @return set of all related shareholders
     */
    @Nonnull
    @Contract(pure = true)
    Set<Kapitalgesellschaft.Shareholder> getRelatedShareholders();
}
