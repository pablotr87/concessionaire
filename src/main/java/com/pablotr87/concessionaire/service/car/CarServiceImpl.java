package com.pablotr87.concessionaire.service.car;

import com.pablotr87.concessionaire.model.car.CarBean;
import com.pablotr87.concessionaire.repository.car.CarRepositoryDao;
import org.springframework.stereotype.Service;

/**
 * Implementation service for car management.
 *
 * @author pablotr87
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

    /**
     * Obtains a full list of cars.
     *
     * @return List of all available cars.
     */
    @Override
    public Iterable<CarBean> getAllCars() {
        return carRepositoryDao.findAll();
    }
}
