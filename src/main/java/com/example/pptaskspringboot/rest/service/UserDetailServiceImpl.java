package com.example.pptaskspringboot.rest.service;

import com.example.pptaskspringboot.rest.dao.UserRepozitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepozitory userRepozitory;

    @Autowired
    public UserDetailServiceImpl(UserRepozitory userRepozitory) {
        this.userRepozitory = userRepozitory;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepozitory.findAllByEmail(email);
    }
}
