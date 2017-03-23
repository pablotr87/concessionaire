package com.ptirador.concessionaire.repository.car;

import com.ptirador.concessionaire.model.car.CarBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * DAO repository for car management.
 *
 * @author ptirador
 */
@Repository
public interface CarRepositoryDao extends CrudRepository<CarBean, String> {

}
