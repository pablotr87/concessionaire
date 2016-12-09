package com.pablotr87.concessionaire.repository.car;

import com.pablotr87.concessionaire.model.car.CarBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author pablotr87
 */
@Repository
public interface CarRepositoryDao extends CrudRepository<CarBean, String> {

}
