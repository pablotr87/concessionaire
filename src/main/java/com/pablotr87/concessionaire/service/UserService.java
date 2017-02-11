package com.pablotr87.concessionaire.service;

import com.pablotr87.concessionaire.model.UserBean;

/**
 * @author pablotr87
 */
public interface UserService {

    /**
     * Finds a user bean by its username.
     *
     * @param username Username.
     * @return User bean object that matches the username. Null otherwise.
     */
    UserBean findByUsername(String username);

    /**
     * Finds a user bean by its id.
     *
     * @param id Id.
     * @return User bean object that matches the id. Null otherwise.
     */
    UserBean findById(String id);

    /**
     * Inserts a user bean into database.
     *
     * @param user User bean.
     * @return Number of affected registers.
     */
    int insertUser(UserBean user);
}
