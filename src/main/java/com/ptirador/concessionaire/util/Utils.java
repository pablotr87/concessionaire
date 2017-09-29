package com.ptirador.concessionaire.util;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

/**
 * Utilities support class.
 *
 * @author ptirador
 */
public final class Utils {

    /**
     * Private constructor.
     */
    private Utils() {

    }

    /**
     * Obtains the authority corresponding to the role id from a user.
     *
     * @param roleId Role identifier.
     * @return List of user authorities.
     */
    public static List<GrantedAuthority> getAuthorities(int roleId) {
        List<GrantedAuthority> authList = new ArrayList<>();
        switch (roleId) {
            case Constants.ROLE_ADMIN_ID:
                authList.add(new SimpleGrantedAuthority(Constants.ROLE_ADMIN));
                break;
            case Constants.ROLE_USER_ID:
                authList.add(new SimpleGrantedAuthority(Constants.ROLE_USER));
                break;
            default:
                break;
        }
        return authList;
    }
}
