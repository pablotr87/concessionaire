package com.pablotr87.concessionaire.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pablotr87.concessionaire.model.car.CarBean;
import com.pablotr87.concessionaire.service.car.CarService;
import com.pablotr87.concessionaire.util.Constants;
import com.pablotr87.concessionaire.util.Utils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Home controller.
 *
 * @author pablotr87
 */
@Controller
public class CarController {

    /**
     * View names.
     */
    private static final String VIEW_CARS_LIST = "carsListView";

    /**
     * URL names.
     */
    private static final String URL_HOME = "/home";
    private static final String URL_GET_CARS = "/cars";

    /**
     * Autowired elements.
     */
    private final CarService carService;

    /**
     * Autowired constructor.
     *
     * @param carService
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
    public String getCarsList() {
        return VIEW_CARS_LIST;
    }

    /**
     * @param response
     * @return
     * @throws JsonProcessingException
     */
    @PreAuthorize(Constants.IS_USER)
    @GetMapping(URL_GET_CARS)
    @ResponseBody
    public void getCars(HttpServletResponse response) throws JsonProcessingException {
        Iterable<CarBean> carsList = carService.getAllCars();
        Utils.exportToJson(response, carsList);
    }
}