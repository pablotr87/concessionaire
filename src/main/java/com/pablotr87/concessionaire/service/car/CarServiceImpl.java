package com.pablotr87.concessionaire.service.car;

import com.pablotr87.concessionaire.model.car.CarBean;
import com.pablotr87.concessionaire.repository.car.CarRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pablotr87
 */
@Service
public class CarServiceImpl implements CarService {
    /**
     * Autowired fields.
     */
    private CarRepositoryDao carRepositoryDao;

    /**
     * Constructor.
     *
     * @param carRepositoryDao
     */
    @Autowired
    public CarServiceImpl(final CarRepositoryDao carRepositoryDao) {
        this.carRepositoryDao = carRepositoryDao;
    }

    /**
     * Obtains a full list of cars.
     *
     * @return
     */
    @Override
    public Iterable<CarBean> getAllCars() {
        return carRepositoryDao.findAll();
    }
}
