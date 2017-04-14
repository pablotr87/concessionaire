package com.ptirador.concessionaire.service;

import com.ptirador.concessionaire.model.User;
import com.ptirador.concessionaire.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * @author ptirador
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * Autowired fields.
     */
    private UserRepository userRepository;

    /**
     * Constructor.
     *
     * @param userRepository
     */
    public UserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Finds a user bean by its username.
     *
     * @param username Username.
     * @return User bean object that matches the username. Null otherwise.
     */
    @Override
    public User findByUsername(final String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * Finds a user bean by its id.
     *
     * @param id Id.
     * @return User bean object that matches the id. Null otherwise.
     */
    @Override
    public User findById(final String id) {
        return userRepository.findOne(id);
    }

    /**
     * Inserts a user bean into database.
     *
     * @param user User bean.
     * @return Number of affected registers.
     */
    @Override
    public int insertUser(final User user) {
        return null != userRepository.save(user) ? 1 : 0;
    }
}
