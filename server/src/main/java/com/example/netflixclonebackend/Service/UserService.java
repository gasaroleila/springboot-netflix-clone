package com.example.netflixclonebackend.Service;

import com.example.netflixclonebackend.Model.User;
import com.example.netflixclonebackend.Repository.UserRepository;
import com.example.netflixclonebackend.utils.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<String> registerUser(User user) {
       try {
           User newUser = new User();
           boolean existingUser = userRepository.findByEmail(user.getEmail()).isPresent();
           if(existingUser) {
               return ResponseEntity.badRequest().body("User Already Exist!");
           }
           newUser.setUsername(user.getUsername());
           newUser.setEmail(user.getEmail());
           newUser.setPassword(user.getPassword());

           userRepository.save(newUser);
           return ResponseEntity.status(HttpStatus.OK).body("User registered successfully");
       }catch (Exception e) {
           System.out.println(user.getId());
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There was an error!"+e);
       }
   }

    public ResponseEntity login(User user) {
       try{
           Optional<User>  loggedInUser= userRepository.findByEmail(user.getEmail());
           Boolean passwordMarch = new BCryptPasswordEncoder().matches(user.getPassword(),loggedInUser.get().getPassword());
           if(loggedInUser.isEmpty()|| !passwordMarch) {
               return ResponseEntity.badRequest().body("Invalid Email or Password!");
           }
           return ResponseEntity.ok().body(loggedInUser);
       }catch(Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There was an error!Try again!"+e);
       }
    }




}
