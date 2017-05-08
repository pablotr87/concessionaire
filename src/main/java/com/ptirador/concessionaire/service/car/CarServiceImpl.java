package com.ptirador.concessionaire.service.car;

import com.ptirador.concessionaire.model.car.Car;
import com.ptirador.concessionaire.repository.car.CarRepositoryDao;
import org.springframework.stereotype.Service;

/**
 * Implementation service for car management.
 *
 * @author ptirador
 */
@Service
public class CarServiceImpl implements CarService {

    /**
     * DAO repository for cars.
     */
    private CarRepositoryDao carRepositoryDao;

    /**
     * Constructor.
     *
     * @param carRepositoryDao DAO repository for cars.
     */
    public CarServiceImpl(final CarRepositoryDao carRepositoryDao) {
        this.carRepositoryDao = carRepositoryDao;
    }

    @Override
    public Iterable<Car> getAllCars() {
        return carRepositoryDao.findAll();
    }

    @Override
    public Car findById(String id) {
        return carRepositoryDao.findOne(id);
    }
}
