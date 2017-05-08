package com.ptirador.concessionaire.controller;

import com.ptirador.concessionaire.model.car.Car;
import com.ptirador.concessionaire.service.car.CarService;
import com.ptirador.concessionaire.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Home controller.
 *
 * @author ptirador
 */
@Controller
@RequestMapping("/cars")
public class CarController extends BaseController<Car> {

    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(CarController.class);
    /**
     * Cars list view name.
     */
    private static final String VIEW_CARS = "carsListView";

    /**
     * Car detail view.
     */
    private static final String VIEW_CAR_DETAIL = "carDetailView";

    /**
     * Export file name.
     */
    private static final String EXPORT_FILE_NAME = "carsList";
    /**
     * Cars list URL.
     */
    private static final String URL_CARS_LIST = "/list";
    /**
     * Cars JSON list URL.
     */
    private static final String URL_CARS_JSON_LIST = "/jsonList";
    /**
     * Cars detail URL.
     */
    private static final String URL_CARS_DETAIL = "/detail/{id}";
    /**
     * URL that saves a car.
     */
    private static final String URL_SAVE_CAR = "/saveCar";
    /**
     * Model attribute for a car detail.
     */
    private static final String MDL_CAR = "car";
    /**
     * Interface service for car management.
     */
    private final CarService carService;

    /**
     * Constructor.
     *
     * @param carService    Interface service for car management.
     * @param messageSource
     */
    public CarController(final CarService carService,
                         final MessageSource messageSource) {
        super(messageSource);
        this.carService = carService;
    }

    /**
     * Mapping for cars list page.
     *
     * @return Cars list view.
     */
    @GetMapping(URL_CARS_LIST)
    public String getCars() {
        return VIEW_CARS;
    }

    /**
     * Exports the full car list to JSON.
     *
     * @param response HTTP response.
     */
    @GetMapping(URL_CARS_JSON_LIST)
    @ResponseBody
    public void getCarsList(HttpServletResponse response) {
        Iterable<Car> carsList = carService.getAllCars();
        Utils.exportToJson(response, carsList);
    }

    /**
     * Car detail.
     *
     */
    @GetMapping(URL_CARS_DETAIL)
    public String getCarDetail(@PathVariable String id,
                               Model model) {
        model.addAttribute(MDL_CAR, carService.findById(id));
        return VIEW_CAR_DETAIL;
    }

    /**
     * Saves an existing car.
     *
     * @param car
     * @param errors
     * @param model
     * @param rda
     * @param locale
     * @return
     */
    @PostMapping(URL_SAVE_CAR)
    public String saveCar( @ModelAttribute(MDL_CAR) @Valid Car car,
                           Errors errors,
                           Model model,
                           RedirectAttributes rda,
                           Locale locale) {

        String pageResultado = VIEW_CAR_DETAIL;

        if (errors.hasErrors()) {
            LOG.error("Error while saving a car");
        } else {

        }

        return VIEW_CAR_DETAIL;
    }

    /**
     * Method to be implemented by children classes to resolve the list to export.
     *
     * @param order
     * @param sort
     * @param search Text to query in JSON format.
     * @param filter
     * @param locale Object that represents country/language.
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Car> getListToExport(String order, String sort, String search, String filter, Locale locale) {
        Iterable<Car> iterable = carService.getAllCars();
        List<Car> target = new ArrayList<>();
        iterable.forEach(target::add);
        return target;
    }

    /**
     * File name to export.
     *
     * @return File name to export.
     */
    @Override
    public String getExportFileName() {
        return EXPORT_FILE_NAME;
    }
}