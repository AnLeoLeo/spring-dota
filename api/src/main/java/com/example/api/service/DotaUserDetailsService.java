package com.example.api.service;

import com.example.api.model.DotaUserPrincipal;
import com.example.api.dao.UserDAO;
import com.example.api.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DotaUserDetailsService implements UserDetailsService {

    private UserDAO repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);
        if (null == user) {
            throw new UsernameNotFoundException(username);
        }
        return new DotaUserPrincipal(user);
    }
}
