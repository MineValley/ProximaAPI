package eu.minevalley.proxima.api.user.team;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum TeamRank {

    /**
     * Members of the "Support"-group.
     */
    SUPPORT,

    /**
     * Members of the "Moderation"-group.
     */
    MODERATION,

    /**
     * Members of the "Sonstiges"-group.
     */
    MISCELLANEOUS,

    /**
     * Members of the "Bauteam"-group.
     */
    BUILDING,

    /**
     * Members of the "Entwicklung"-group.
     */
    DEVELOPMENT,

    /**
     * Members of the "Administration"-group.
     */
    ADMINISTRATION,

    /**
     * Members of the "Serverleitung"-group.
     */
    SERVER_LEAD;
}