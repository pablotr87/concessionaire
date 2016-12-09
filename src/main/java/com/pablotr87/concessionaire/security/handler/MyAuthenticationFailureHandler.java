package com.pablotr87.concessionaire.security.handler;

import com.pablotr87.concessionaire.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Failure handler in user authentication.
 *
 * @author pablotr87
 */
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(MyAuthenticationFailureHandler.class);

    /**
     * Constants.
     */
    private static final String URL_ERROR = "login?error=";


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException e) throws IOException, ServletException {
        String username = request.getParameter("username");
        String errorCode;

        if (e instanceof CredentialsExpiredException) {
            LOG.error("Credentials expired for user : " + username, e);
            errorCode = Constants.LOGIN_ERROR_CREDENTIALS_EXPIRED;

        } else {
            LOG.error("Bad credentials for user : " + username, e);
            errorCode = Constants.LOGIN_ERROR_BAD_CREDENTIALS;
        }

        response.sendRedirect(URL_ERROR + errorCode);
    }
}