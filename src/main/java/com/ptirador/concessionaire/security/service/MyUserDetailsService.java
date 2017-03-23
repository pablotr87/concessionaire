package com.ptirador.concessionaire.security.service;

import com.ptirador.concessionaire.model.UserBean;
import com.ptirador.concessionaire.repository.UserRepositoryDao;
import com.ptirador.concessionaire.util.Utils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ptirador
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

    @Resource
    private UserRepositoryDao userRepositoryDao;

    /**
     * Obtains a user from DB by its username.
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        UserDetails userDetails = null;

        if (!StringUtils.isEmpty(username)) {
            UserBean user = userRepositoryDao.findByUsername(username);
            if (null != user) {
                List<GrantedAuthority> authorities = Utils.getAuthorities(user.getRole());
                userDetails = new User(user.getUsername(), user.getPassword(), authorities);
            }
        }

        return userDetails;
    }
}