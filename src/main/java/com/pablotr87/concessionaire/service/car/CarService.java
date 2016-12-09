package com.pablotr87.concessionaire.service.car;

import com.pablotr87.concessionaire.model.car.CarBean;

/**
 * @author pablotr87
 */
public interface CarService {

    /**
     * Obtains a full list of cars.
     * @return
     */
    Iterable<CarBean> getAllCars();
}
