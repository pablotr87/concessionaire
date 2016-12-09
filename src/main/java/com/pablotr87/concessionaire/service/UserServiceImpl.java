package com.pablotr87.concessionaire.service;

import com.pablotr87.concessionaire.model.UserBean;
import com.pablotr87.concessionaire.repository.UserRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author pablotr87
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * Autowired fields.
     */
    private UserRepositoryDao userRepositoryDao;

    /**
     * Constructor.
     *
     * @param userRepositoryDao
     */
    @Autowired
    public UserServiceImpl(final UserRepositoryDao userRepositoryDao) {
        this.userRepositoryDao = userRepositoryDao;
    }

    /**
     * Finds a user bean by its username.
     *
     * @param username Username.
     * @return User bean object that matches the username. Null otherwise.
     */
    @Override
    public UserBean findByUsername(final String username) {
        return userRepositoryDao.findByUsername(username);
    }

    /**
     * Finds a user bean by its id.
     *
     * @param id Id.
     * @return User bean object that matches the id. Null otherwise.
     */
    @Override
    public UserBean findById(final String id) {
        return userRepositoryDao.findOne(id);
    }

    /**
     * Inserts a user bean into database.
     *
     * @param user User bean.
     * @return
     */
    @Override
    public int insertUser(final UserBean user) {
        return null != userRepositoryDao.save(user) ? 1 : 0;
    }
}
