package com.pablotr87.concessionaire.controller;

import com.pablotr87.concessionaire.service.car.CarService;
import com.pablotr87.concessionaire.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Home controller.
 *
 * @author pablotr87
 */
@Controller
public class CarController {

    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(CarController.class);

    /**
     * View names.
     */
    private static final String VIEW_CARS_LIST = "carsListView";

    /**
     * URL names.
     */
    private static final String URL_HOME = "/home";

    /**
     * Model attribute names.
     */
    private static final String MDL_CARS = "cars";

    /**
     * Autowired elements.
     */
    private final CarService carService;

    /**
     * Autowired constructor.
     *
     * @param carService
     */
    @Autowired
    public CarController(final CarService carService) {
        this.carService = carService;
    }

    /**
     * Mapping for returning cars list page.
     *
     * @param model Model object.
     * @return Cars list page.
     */
    @PreAuthorize(Constants.IS_USER)
    @GetMapping(URL_HOME)
    public String getCarsList(Model model) {
        model.addAttribute(MDL_CARS, carService.getAllCars());
        return VIEW_CARS_LIST;
    }
}