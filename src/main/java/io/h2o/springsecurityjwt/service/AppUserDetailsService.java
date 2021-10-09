package io.h2o.springsecurityjwt.service;

import io.h2o.springsecurityjwt.models.User;
import io.h2o.springsecurityjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = userRepository.findByUserName(userName);
        ArrayList<SimpleGrantedAuthority> auth = new ArrayList<>();
        SimpleGrantedAuthority role = new SimpleGrantedAuthority("ROLE_USER");
        auth.add(role);
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),auth);


//        ArrayList<SimpleGrantedAuthority> auth = new ArrayList<>();
//        SimpleGrantedAuthority role = new SimpleGrantedAuthority("ROLE_USER");
//        auth.add(role);
//        return new User("amit","amit",auth);
    }
}
