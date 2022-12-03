package com.example.netflixclonebackend.utils;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class Validator {
    private static int PASSWORD_MIN_LENGTH = 8;
    private static int USERNAME_MIN_LENGTH = 6;
    private static ValidatorResponse validatorResponse = new ValidatorResponse();
    public static ValidatorResponse validateRegisterData(String username, String emailAddress, String password) {
        String regex = "^(.+)@(\\S+)$";
        Boolean isValidEmail =  Pattern.compile(regex).matcher(emailAddress).matches();
        Boolean isValidPassword = password.length() >= PASSWORD_MIN_LENGTH;
        Boolean isValidUsername = username.length() >= USERNAME_MIN_LENGTH;

        if(!isValidEmail) {
           validatorResponse.setMessage("Email is Invalid!");
           validatorResponse.setValidation(false);
        }
        if(!isValidPassword){
            validatorResponse.setMessage("Password should be atleast 8 characters!");
            validatorResponse.setValidation(false);
        }

        if(!isValidUsername){
            validatorResponse.setMessage("Username should be atleast 6 characters!");
            validatorResponse.setValidation(false);
        }

        if(isValidEmail && isValidPassword && isValidUsername) {
            validatorResponse.setMessage("Validation successful!");
            validatorResponse.setValidation(true);
        }

        return validatorResponse;
    }

    public static ValidatorResponse validateLoginData(String emailAddress, String password) {
        String regex = "^(.+)@(\\S+)$";
        Boolean isValidEmail =  Pattern.compile(regex).matcher(emailAddress).matches();
        Boolean isValidPassword = password.length() >= PASSWORD_MIN_LENGTH;

        if(!isValidEmail) {
            validatorResponse.setMessage("Email is Invalid!");
            validatorResponse.setValidation(false);
        }
        if(!isValidPassword){
            validatorResponse.setMessage("Password should be atleast 8 characters!");
            validatorResponse.setValidation(false);
        }

        if(isValidEmail && isValidPassword) {
            validatorResponse.setMessage("Validation successful!");
            validatorResponse.setValidation(true);
        }

        return validatorResponse;
    }


}