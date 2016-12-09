package com.pablotr87.concessionaire.repository;

import com.pablotr87.concessionaire.model.UserBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author pablotr87
 */
@Repository
public interface UserRepositoryDao extends CrudRepository<UserBean, String> {

    /**
     * Finds a user bean by its username.
     *
     * @param username Username.
     * @return User bean object that matches the username. Null otherwise.
     */
    UserBean findByUsername(String username);
}
