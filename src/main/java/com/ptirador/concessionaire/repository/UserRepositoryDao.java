package com.ptirador.concessionaire.repository;

import com.ptirador.concessionaire.model.UserBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ptirador
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
