package com.ptirador.concessionaire.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Utilities support class.
 *
 * @author ptirador
 */
public final class Utils {

    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(Utils.class);

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

    /**
     * Converts a object to String in JSON format.
     *
     * @param response HTTP response object.
     * @param bean     Java object to convert.
     */
    public static void exportToJson(HttpServletResponse response, Object bean) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(bean);
            PrintWriter writer = response.getWriter();
            writer.write(jsonString);
            writer.flush();
        } catch (IOException e) {
            LOG.error("Conversion error to JSON", e);
        }
    }
}
