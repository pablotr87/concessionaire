package com.ptirador.concessionaire.controller;

import com.ptirador.concessionaire.exception.ResourceNotFoundException;
import com.ptirador.concessionaire.model.car.Car;
import com.ptirador.concessionaire.service.car.CarService;
import com.ptirador.concessionaire.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.*;

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
    private static final String URL_CARS_DETAIL = "/detail/{id:.+}";
    /**
     * URL that saves a car.
     */
    private static final String URL_SAVE_CAR = "/saveCar";
    /**
     * Model attribute for a car detail.
     */
    private static final String MDL_CAR = "car";
    /**
     * Message code for saving succesfully a car.
     */
    private static final String MSG_CAR_SAVE_OK = "car.save.ok";
    /**
     * Message code for failed saving of a car.
     */
    private static final String MSG_CAR_SAVE_KO = "car.save.ko";
    /**
     * Interface service for car management.
     */
    private final CarService carService;

    /**
     * Constructor.
     *
     * @param carService    Interface service for car management.
     * @param messageSource Interface for resolving messages.
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
     * @return Cars list in JSON format.
     */
    @GetMapping(value = URL_CARS_JSON_LIST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Iterable<Car> getCarsList() {
        return carService.findAll();
    }

    /**
     * Car detail.
     */
    @GetMapping(URL_CARS_DETAIL)
    public String getCarDetail(@PathVariable String id,
                               Model model) {
        Car car = carService.findById(id);
        if (null == car) {
            throw new ResourceNotFoundException();
        }

        model.addAttribute(MDL_CAR, car);
        return VIEW_CAR_DETAIL;
    }

    /**
     * Saves an existing car.
     *
     * @param car
     * @param errors
     * @param rda
     * @return
     */
    @PostMapping(value = URL_SAVE_CAR)
    public String saveCar(@ModelAttribute(MDL_CAR) @Valid Car car,
                          Errors errors,
                          RedirectAttributes rda) {

        String resultPage = VIEW_CAR_DETAIL;

        if (errors.hasErrors()) {
            LOG.error("Error while saving a car");
        } else {
            carService.save(car);
            resultPage = Constants.REDIRECT + "/cars/detail/" + car.getId();
            rda.addFlashAttribute(Constants.MSG, MSG_CAR_SAVE_OK);
        }

        return resultPage;
    }

    /**
     * Method to be implemented by children classes to resolve the list to export.
     *
     * @param order sort order.
     * @param sort sort field.
     * @param search Text to query in JSON format.
     * @param locale Object that represents country/language.
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Car> getListToExport(String order, String sort, String search, Locale locale) {
        return carService.findByAnyField(search, sort, order);
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