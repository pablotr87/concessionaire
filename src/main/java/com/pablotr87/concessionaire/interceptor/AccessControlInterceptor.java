package com.pablotr87.concessionaire.interceptor;

import com.pablotr87.concessionaire.model.UserBean;
import com.pablotr87.concessionaire.service.UserService;
import com.pablotr87.concessionaire.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

/**
 * @author pablotr87
 */
public class AccessControlInterceptor extends HandlerInterceptorAdapter {

    /**
     * Autowired fields.
     */
    private UserService userService;
    private LocaleResolver localeResolver;

    /**
     * Members.
     */
    private boolean userExists;

    /**
     * Constructor.
     *
     * @param userService
     */
    public AccessControlInterceptor(final UserService userService,
                                    final LocaleResolver localeResolver) {
        this.userService = userService;
        this.localeResolver = localeResolver;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws ServletException, IOException {

        validateUserAccess(request, response);

        return true;
    }

    /**
     * Validate the user access for every request.
     *
     * @param request
     * @param response
     */
    private void validateUserAccess(HttpServletRequest request,
                                    HttpServletResponse response) {
        HttpSession session = request.getSession();
        UserBean sessionUser = (UserBean) session.getAttribute(Constants.USER_LOGIN);

        // If user access for first time...
        if (StringUtils.isEmpty(sessionUser)) {
            // Checking user registered in the application.
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (null != auth) {
                String username = auth.getName();
                UserBean dbUser = userService.findByUsername(username);
                this.setUserExists(null != dbUser);
                if (isUserExists()) {

                    sessionUser = dbUser;

                    // Set locale for user
                    Locale locale = Locale.getDefault();
                    this.localeResolver.setLocale(request, response, locale);
                    sessionUser.setLanguage(locale.getLanguage());

                    // Add user bean to session to not query again in DB.
                    session.setAttribute(Constants.USER_LOGIN, sessionUser);
                }
            }
        }

        if (!isUserExists()) {
            session.removeAttribute(Constants.USER_LOGIN);
        }
    }

    /**
     * Obtains the userExists member.
     * @return
     */
    public boolean isUserExists() {
        return userExists;
    }

    /**
     * Establishes the userExists member.
     * @param userExists
     */
    public void setUserExists(boolean userExists) {
        this.userExists = userExists;
    }
}
