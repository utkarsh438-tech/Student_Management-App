package com.Springconcept.Learning.Service.Imp;

import com.Springconcept.Learning.Model.Users;
import com.Springconcept.Learning.Repository.UserRepo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {

    private UserRepo userRepo;
    public UserServiceImpl(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
Users users=userRepo.findByUsername(username).orElseThrow(()->new UsernameNotFoundException(username));
        return User.withUsername(username).password(users.getPassword()).roles("USER").build();
    }

}
