package com.ptirador.concessionaire.controller;

import com.ptirador.concessionaire.model.car.CarBean;
import com.ptirador.concessionaire.service.car.CarService;
import com.ptirador.concessionaire.util.Constants;
import com.ptirador.concessionaire.util.Utils;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
public class CarController extends BaseController<CarBean> {

    /**
     * Cars list view name.
     */
    private static final String VIEW_CARS = "carsListView";

    /**
     * Export file name.
     */
    private static final String EXPORT_FILE_NAME = "carsList";
    /**
     * Interface service for car management.
     */
    private final CarService carService;

    /**
     * Constructor.
     *
     * @param carService Interface service for car management.
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
    @PreAuthorize(Constants.IS_USER)
    @GetMapping("/list")
    public String getCars() {
        return VIEW_CARS;
    }

    /**
     * Exports the full car list to JSON.
     *
     * @param response HTTP response.
     */
    @PreAuthorize(Constants.IS_USER)
    @GetMapping("/jsonList")
    @ResponseBody
    public void getCarsList(HttpServletResponse response) {
        Iterable<CarBean> carsList = carService.getAllCars();
        Utils.exportToJson(response, carsList);
    }

    /**
     * Method to be implemented by children classes to resolve the list to export.
     *
     * @param order
     * @param sort
     * @param search
     * @param filter
     * @param locale
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<CarBean> getListToExport(String order, String sort, String search, String filter, Locale locale) {
        Iterable<CarBean> iterable = carService.getAllCars();
        List<CarBean> target = new ArrayList<>();
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