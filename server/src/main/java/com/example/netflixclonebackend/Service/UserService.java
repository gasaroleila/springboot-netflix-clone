package com.example.netflixclonebackend.Service;

import com.example.netflixclonebackend.Model.User;
import com.example.netflixclonebackend.Repository.UserRepository;
import com.example.netflixclonebackend.utils.LoginRequest;
import com.example.netflixclonebackend.utils.Validator;
import com.example.netflixclonebackend.utils.ValidatorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import javax.swing.text.html.Option;
import java.util.Optional;

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<String> registerUser(User user) {
       try {
           boolean existingUser = userRepository.findByEmail(user.getEmail()).isPresent();
           if(existingUser) {
               return ResponseEntity.badRequest().body("User Already Exist!");
           }
           userRepository.save(user);
           return ResponseEntity.status(HttpStatus.OK).body("User registered successfully");
       }catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There was an error!");
       }
   }

    public ResponseEntity login(LoginRequest user) {
       try{
           Optional<User>  loggedInUser= userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
           if(loggedInUser.isEmpty()) {
               return ResponseEntity.badRequest().body("Invalid Email or Password!");
           }
           return ResponseEntity.ok().body(loggedInUser);
       }catch(Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There was an error!Try again!");
       }
    }
}
