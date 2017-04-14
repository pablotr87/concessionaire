package com.ptirador.concessionaire.repository;

import com.ptirador.concessionaire.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ptirador
 */
@Repository
public interface UserRepository extends CrudRepository<User, String> {

    /**
     * Finds a user bean by its username.
     *
     * @param username Username.
     * @return User bean object that matches the username. Null otherwise.
     */
    User findByUsername(String username);
}
