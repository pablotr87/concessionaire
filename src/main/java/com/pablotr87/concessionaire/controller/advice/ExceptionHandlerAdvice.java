package com.pablotr87.concessionaire.controller.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Exception handler advice.
 *
 * @author pablotr87
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    /**
     * View for generic errors.
     */
    private static final String VIEW_GENERIC_ERROR = "errorView";

    /**
     * View for access denied errors.
     */
    private static final String VIEW_ACCESS_DENIED_ERROR = "accessDeniedView";

    /**
     * View for resources not found.
     */
    private static final String VIEW_NOT_FOUND_ERROR = "notFoundView";

    /**
     * @param e Exception object.
     * @return
     */
    @ExceptionHandler({Exception.class, RuntimeException.class})
    public String handleGenericException(final Exception e) {
        LOG.error("Generic error", e);
        return VIEW_GENERIC_ERROR;
    }

    /**
     * @param e Access denied exception object.
     * @return
     */
    @ExceptionHandler(AccessDeniedException.class)
    public String handleAccessDeniedException(final AccessDeniedException e) {
        LOG.error("Access denied error", e);
        return VIEW_ACCESS_DENIED_ERROR;
    }

    /**
     * @param e Handler not found exception object.
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public String handleNotFoundException(final NoHandlerFoundException e) {
        LOG.error("Resource URL was not found", e);
        return VIEW_NOT_FOUND_ERROR;
    }
}
