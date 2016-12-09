package com.pablotr87.concessionaire.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller that manages the search petitions.
 * @author pablotr87
 */
@Controller
public class ErrorController {

    /**
     * View names.
     */
    private static final String VIEW_ACCESS_DENIED = "accesDeniedView";

    /**
     * URL names.
     */
    private static final String URL_ACCESS_DENIED = "/accessDenied";

    /**
     * Mapping for access denied page.
     * @return aaa
     */
    @GetMapping(URL_ACCESS_DENIED)
    public String accessDenied() {
        return VIEW_ACCESS_DENIED;
    }
}
