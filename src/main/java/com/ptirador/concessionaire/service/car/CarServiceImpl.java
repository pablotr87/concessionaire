package com.ptirador.concessionaire.service.car;

import com.ptirador.concessionaire.model.car.Car;
import com.ptirador.concessionaire.repository.car.CarRepositoryDao;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Car> getAllCars() {
        Sort sortByMakeAndModel = new Sort(Sort.Direction.ASC, "make", "model", "year");
        return carRepositoryDao.findAll(sortByMakeAndModel);
    }

    @Override
    public Car findById(String id) {
        return carRepositoryDao.findOne(id);
    }

    @Override
    public Car save(Car car) {
        return carRepositoryDao.save(car);
    }
}
