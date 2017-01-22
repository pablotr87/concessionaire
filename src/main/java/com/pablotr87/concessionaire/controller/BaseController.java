package com.pablotr87.concessionaire.controller;

import org.springframework.context.MessageSource;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Locale;

/**
 * Abstract class that contains common variables and methods.
 *
 * @author pablotr87
 */
public abstract class BaseController {

    /**
     * View names.
     */
    private static final String EXCEL_VIEW = "excelView";

    /**
     * Model attribute names.
     */
    private static final String MDL_EXPORT_LIST = "list";
    private static final String MDL_HEADERS_NAMES = "headersNames";
    private static final String MDL_IDS = "ids";
    private static final String MDL_FILE_NAME = "fileName";

    /**
     * Interface for resolving messages.
     */
    private MessageSource messageSource;

    /**
     * CoNstructor with params.
     *
     * @param messageSource Interface for resolving messages.
     */
    public BaseController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * Method for children classes to implement and will resolve the list to export.
     *
     * @param order
     * @param sort
     * @param search
     * @param filter
     * @param locale
     * @return
     */
    public abstract List<?> getListToExport(String order, String sort, String search, String filter, Locale locale);

    /**
     * File name to export.
     *
     * @return
     */
    public abstract String getFileNameToExport();

    /**
     * Excel file export.
     *
     * @param model
     * @param headersNames
     * @param identifiers
     * @param order
     * @param search
     * @param filter
     * @param sort
     * @param locale
     * @return
     */
    @GetMapping(value = "/exportExcelFile",
            produces = {"application/vnd.ms-excel; charset=UTF-8"})
    public final String exportToExcel(Model model, @RequestParam List<String> headersNames,
                                      @RequestParam List<String> identifiers,
                                      @RequestParam(required = false) String order,
                                      @RequestParam(required = false) String search,
                                      @RequestParam(required = false) String filter,
                                      @RequestParam(required = false) String sort,
                                      Locale locale) {

        model.addAttribute(MDL_EXPORT_LIST, getListToExport(order, sort, search, filter, locale));
        model.addAttribute(MDL_HEADERS_NAMES, headersNames);
        model.addAttribute(MDL_IDS, identifiers);
        model.addAttribute(MDL_FILE_NAME, getFileNameToExport());
        return EXCEL_VIEW;
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
