package com.rhkiswani.backbasetask.web.config.security;

import com.rhkiswani.backbasetask.core.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.rhkiswani.backbasetask.core.entites.User user = repository.getByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("username not found");
        }
        return new User(username,
                user.getPassword(),
                user.isActive(),
                true,
                true,
                true, Arrays.asList((GrantedAuthority) () -> user.getRole().name()));
    }
}
