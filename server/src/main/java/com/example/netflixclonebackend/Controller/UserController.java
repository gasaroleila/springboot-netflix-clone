package com.example.netflixclonebackend.Controller;

import com.example.netflixclonebackend.Model.User;
import com.example.netflixclonebackend.utils.Validator;
import com.example.netflixclonebackend.utils.ValidatorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@RestController
public class UserController {

    private Validator validator = new Validator();
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @PostMapping("/auth/register")
    public ResponseEntity<String> register(User user) {
        ValidatorResponse validatorResponse = validator.validateRegisterData(user.getUsername(),user.getEmail(), user.getPassword());
        if(!validatorResponse.getValidation()) {
            return ResponseEntity.badRequest().body(validatorResponse.getMessage());
        }

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));


        return null;
    }
}
