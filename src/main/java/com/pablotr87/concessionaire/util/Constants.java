package com.pablotr87.concessionaire.util;

/**
 * Constants variables class.
 *
 * @author pablotr87
 */
public final class Constants {

    /**
     * Redirect URLs.
     */
    public static final String REDIRECT = "redirect:";
    /**
     * Email pattern.
     */
    public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    /**
     * Special characters pattern: <([{\^-=$!|]})?*+.>
     */
    public static final String SPECIAL_CHARS_PATTERN = "<(\\[{\\\\\\^\\-=$!\\]})?*+.>";
    /**
     * Password pattern.
     */
    public static final String PSWD_PATTERN =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[" + SPECIAL_CHARS_PATTERN + "])"
                    + "[a-zA-Z\\d" + SPECIAL_CHARS_PATTERN + "]{8,}$";
    /**
     * Attribute ok message.
     */
    public static final String MSG = "msg";
    /**
     * Attribute error message.
     */
    public static final String MSG_ERROR = "errorMsg";
    /**
     * Bad credentials code error.
     */
    public static final String LOGIN_ERROR_BAD_CREDENTIALS = "badCredentials";
    /**
     * Credentials expired code error.
     */
    public static final String LOGIN_ERROR_CREDENTIALS_EXPIRED = "credentialsExpired";
    /**
     * Role administrator id.
     */
    public static final int ROLE_ADMIN_ID = 1;
    /**
     * Role user id.
     */
    public static final int ROLE_USER_ID = 2;
    /**
     * Administrator role name.
     */
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    /**
     * User role name.
     */
    public static final String ROLE_USER = "ROLE_USER";
    /**
     * Role checking to securize URLs.
     */
    public static final String IS_USER = "hasAnyRole('" + ROLE_ADMIN + "', '" + ROLE_USER + "')";
    /**
     * Session attribute for a logged user.
     */
    public static final String USER_LOGIN = "user";

    /**
     * Private constructor.
     */
    private Constants() {

    }
}
