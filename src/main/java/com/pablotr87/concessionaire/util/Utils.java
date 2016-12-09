package com.pablotr87.concessionaire.util;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pablotr87
 */
public final class Utils {

    private Utils() {

    }

    /**
     * @param roleId
     *
     * @return
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
