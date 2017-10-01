package com.ptirador.concessionaire.controller;

import org.springframework.context.MessageSource;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Locale;

import static com.ptirador.concessionaire.util.Constants.*;

/**
 * Abstract class that contains common variables and methods.
 *
 * @param <T>
 * @author ptirador
 */
public abstract class BaseController<T> {

    /**
     * Spreadsheet view.
     */
    private static final String VIEW_SPREADSHEET = "spreadsheetView";

    /**
     * Interface for resolving messages.
     */
    private MessageSource messageSource;

    /**
     * Constructor with params.
     *
     * @param messageSource Interface for resolving messages.
     */
    public BaseController(final MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * Obtains the interface for resolving messages.
     *
     * @return Interface for resolving messages.
     */
    public MessageSource getMessageSource() {
        return messageSource;
    }

    /**
     * Method to be implemented by children classes to resolve the list to export.
     *
     * @param order
     * @param sort
     * @param search
     * @param locale
     * @return
     */
    public abstract List<T> getListToExport(String order, String sort, String search, Locale locale);

    /**
     * File name to export.
     *
     * @return File name to export.
     */
    public abstract String getExportFileName();

    /**
     * Export a data list to a spreadsheet.
     *
     * @param model
     * @param header
     * @param ids
     * @param order
     * @param search
     * @param sort
     * @param locale
     * @return
     */
    @GetMapping(value = "/exportToSpreadsheet",
            produces = {"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet; charset=UTF-8"})
    public final String exportToSpreadsheet(Model model,
                                            @RequestParam List<String> header,
                                            @RequestParam List<String> ids,
                                            @RequestParam(required = false) String order,
                                            @RequestParam(required = false) String search,
                                            @RequestParam(required = false) String sort,
                                            Locale locale) {

        model.addAttribute(MDL_BASE_LIST, getListToExport(order, sort, search, locale));
        model.addAttribute(MDL_BASE_HEADER, header);
        model.addAttribute(MDL_BASE_IDS, ids);
        model.addAttribute(MDL_BASE_FILENAME, getExportFileName());
        return VIEW_SPREADSHEET;
    }
}
