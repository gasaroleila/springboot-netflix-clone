package com.example.netflixclonebackend.util;

import com.example.netflixclonebackend.utils.Validator;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ValidatorTest {
  @Test
    public void passwordShouldHaveMinLength() {
     String password = "pass1234";
     Validator validator = new Validator();
     assertTrue(validator.validatePassword(password));
  }

  public void pass
}
