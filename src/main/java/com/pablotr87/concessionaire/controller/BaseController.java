package com.pablotr87.concessionaire.controller;

import org.springframework.context.MessageSource;

/**
 * Abstract class that contains common variables and methods.
 *
 * @author pablotr87
 */
public abstract class BaseController {

    /**
     * Interface for resolving messages.
     */
    private MessageSource messageSource;

    /**
     * CoNstructor with params.
     *
     * @param messageSourceNew Interface for resolving messages.
     */
    public BaseController(final MessageSource messageSourceNew) {
        this.messageSource = messageSourceNew;
    }

    /**
     * Obtains the interface for resolving messages.
     *
     * @return Interface for resolving messages.
     */
    public MessageSource getMessageSource() {
        return messageSource;
    }
}
