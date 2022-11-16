package com.example.netflixclonebackend.util;

import com.example.netflixclonebackend.utils.Validator;
import com.example.netflixclonebackend.utils.ValidatorResponse;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ValidatorTest {
  @Test
    public void passwordAndUsernameShouldHaveMinLengthAndEmailshouldBeValid() {
     String password = "pass1234";
      String email = "leila@gmail.com";
      String username = "Gasaro";
     Validator validator = new Validator();
     ValidatorResponse validatorResponse =  validator.validateRegisterData(username,email,password);
     assertTrue(validatorResponse.getMessage(), validatorResponse.getValidation());
  }

}
