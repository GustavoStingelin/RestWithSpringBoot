package br.com.stingelin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.stingelin.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        var user = repository.findByUsername(userName);
        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException("Username " + userName + " not found.");
        }
    }

}
