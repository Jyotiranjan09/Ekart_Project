package com.spring.EkartUserService.service;

import com.spring.EkartUserService.entity.User;
import com.spring.EkartUserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;

    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

    public User register(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public String verify(User user) {
        Authentication authentication=
                authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated())
            return jwtService.generateToken(user.getUsername());
        return "Fail";
    }
//    @Autowired
//    private UserRepository userRepository;
//
//    public User saveUser(User user){
//        return userRepository.save(user);
//    }
//
//    public User updateUser(long id,User user){
//        if(userRepository.findById(id).isPresent()){
//            user.setId(id);
//            return userRepository.save(user);
//        }
//        return null;
//    }
//
//    public User deleteUser(long id){
//        if(userRepository.findById(id).isPresent()){
//            User user=userRepository.findById(id).get();
//            userRepository.deleteById(id);
//            return user;
//        }
//        else{
//            return null;
//        }
//    }
//    public User getUserById(long id){
//        if(userRepository.findById(id).isPresent()){
//            User user=userRepository.findById(id).get();
//            return user;
//        }
//        else{
//            return null;
//        }
//    }
//
//    public List<User> getAllUser(){
//        return userRepository.findAll();
//    }
}
