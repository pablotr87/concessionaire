package com.pablotr87.concessionaire.security.service;

import com.pablotr87.concessionaire.model.UserBean;
import com.pablotr87.concessionaire.repository.UserRepositoryDao;
import com.pablotr87.concessionaire.util.Utils;
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
 * @author pablotr87
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

    @Resource
    private UserRepositoryDao userRepositoryDao;

    /**
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
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