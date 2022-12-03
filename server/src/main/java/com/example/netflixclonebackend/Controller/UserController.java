package com.example.netflixclonebackend.Controller;

import com.example.netflixclonebackend.Model.User;
import com.example.netflixclonebackend.Service.UserService;
import com.example.netflixclonebackend.utils.LoginRequest;
import com.example.netflixclonebackend.utils.Validator;
import com.example.netflixclonebackend.utils.ValidatorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@RestController
public class UserController {

    private Validator validator = new Validator();
    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody  User user) {
        try {
            ValidatorResponse validatorResponse = validator.validateRegisterData(user.getUsername(), user.getEmail(), user.getPassword());
            if (!validatorResponse.getValidation()) {
                return ResponseEntity.badRequest().body(validatorResponse.getMessage());
            }

            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            return userService.registerUser(user);


        }catch (Exception e) {
            System.out.println("Exception"+e);
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest userData) {
        try {
            ValidatorResponse validatorResponse = validator.validateLoginData(userData.getEmail(), userData.getPassword());
            if (!validatorResponse.getValidation()) {
                return ResponseEntity.badRequest().body(validatorResponse.getMessage());
            }

           return userService.login(userData);

        }catch (Exception e) {
            System.out.println("Exception"+e);
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
