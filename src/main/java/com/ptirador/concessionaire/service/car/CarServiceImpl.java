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
    public List<Car> findAll() {
        Sort sort = getDefaultSort();
        return carRepositoryDao.findAll(sort);
    }

    private Sort getDefaultSort() {
        return new Sort(Sort.Direction.ASC, "make", "model", "year");
    }

    @Override
    public List<Car> findByAnyField(String search, String sortField, String order) {
        Sort sort;
        if ("undefined".equals(sortField)) {
            sort = getDefaultSort();
        } else {
            sort = new Sort(Sort.Direction.fromString(order), sortField);
        }

        return carRepositoryDao.findByMakeLikeOrModelLikeAllIgnoreCase(search, search, sort);
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
