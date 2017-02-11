package com.pablotr87.concessionaire.controller;

import com.pablotr87.concessionaire.model.car.CarBean;
import com.pablotr87.concessionaire.service.car.CarService;
import com.pablotr87.concessionaire.util.Constants;
import com.pablotr87.concessionaire.util.Utils;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Home controller.
 *
 * @author pablotr87
 */
@Controller
public class CarController {

    /**
     * Cars list view name.
     */
    protected static final String VIEW_CARS_LIST = "carsListView";

    /**
     * URL name to access the home page.
     */
    protected static final String URL_HOME = "/home";

    /**
     * URL name to access the cars list page.
     */
    protected static final String URL_GET_CARS = "/cars";

    /**
     * Interface service for car management.
     */
    private final CarService carService;

    /**
     * Constructor.
     *
     * @param carService Interface service for car management.
     */
    public CarController(final CarService carService) {
        this.carService = carService;
    }

    /**
     * Mapping for returning cars list page.
     *
     * @return Cars list page.
     */
    @PreAuthorize(Constants.IS_USER)
    @GetMapping(URL_HOME)
    public String getCarsListPage() {
        return VIEW_CARS_LIST;
    }

    /**
     * Exports the full car list to JSON.
     *
     * @param response HTTP response.
     */
    @PreAuthorize(Constants.IS_USER)
    @GetMapping(URL_GET_CARS)
    @ResponseBody
    public void getCarsList(HttpServletResponse response) {
        Iterable<CarBean> carsList = carService.getAllCars();
        Utils.exportToJson(response, carsList);
    }
}