package com.example.netflixclonebackend.utils;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class Validator {
    private static int MIN_LENGTH = 8;
    public static boolean validateEmail(String emailAddress) {
        return Pattern.compile("^(.+)@(\\\\S+)$")
                .matcher(emailAddress)
                .matches();
    }

    public boolean validatePassword(String password) {
        return password.length() >= MIN_LENGTH;
    }
}