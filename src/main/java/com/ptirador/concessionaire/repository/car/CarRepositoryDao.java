package com.ptirador.concessionaire.repository.car;

import com.ptirador.concessionaire.model.car.Car;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO repository for car management.
 *
 * @author ptirador
 */
@Repository
public interface CarRepositoryDao extends MongoRepository<Car, String> {

    List<Car> findByMakeLikeOrModelLikeAllIgnoreCase(String make, String model, Sort sort);
}
