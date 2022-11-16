package com.example.netflixclonebackend.Service;

import com.example.netflixclonebackend.Model.User;
import com.example.netflixclonebackend.Repository.UserRepository;
import com.example.netflixclonebackend.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> registerUser(User user) {
       try {
          Boolean isValidEmail = Validator.validateEmail(user.getEmail());
           if (!isValidEmail) {
               throw new IllegalStateException("email not valid");
           }


           userRepository.save(user);
           return ResponseEntity.status(HttpStatus.OK).body("User registered successfully");
       }catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There was an error!");
       }
   }

    public ResponseEntity<?> login(User loggedInUser) {
//       Response response = null;
       try{
           Optional<User> userDetail = userRepository.findByEmailAndPassword(loggedInUser.getEmail(), loggedInUser.getPassword());
//           response.setMessage("Login Successful");
//           response.setData(userDetail);
           return ResponseEntity.ok().body(userDetail);
       }catch(Exception e) {
//           response.setMessage("There was an error!");
//           response.setData(Optional.empty());
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There was an error!");
       }
    }
}
