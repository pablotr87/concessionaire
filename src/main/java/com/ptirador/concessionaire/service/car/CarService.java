package com.ptirador.concessionaire.service.car;

import com.ptirador.concessionaire.model.car.Car;

import java.util.List;

/**
 * Interface service for car management.
 *
 * @author ptirador
 */
public interface CarService {

    /**
     * Obtains a full list of cars.
     *
     * @return List of all available cars.
     */
    List<Car> getAllCars();

    /**
     * Obtain a car by id.
     *
     * @param id Car identificator.
     * @return Car with the corresponding id.
     */
    Car findById(String id);

    /**
     * Saves a car object.
     * @param car car object.
     * @return the saved object.
     */
    Car save(Car car);
}
