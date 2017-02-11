package com.pablotr87.concessionaire.service.car;

import com.pablotr87.concessionaire.model.car.CarBean;

/**
 * Interface service for car management.
 *
 * @author pablotr87
 */
public interface CarService {

    /**
     * Obtains a full list of cars.
     *
     * @return List of all available cars.
     */
    Iterable<CarBean> getAllCars();
}
