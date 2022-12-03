package com.example.netflixclonebackend.Service;

import com.example.netflixclonebackend.Model.User;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.example.netflixclonebackend.Repository.UserRepository;
import com.example.netflixclonebackend.utils.LoginRequest;
import org.apache.coyote.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepositoryMock;

    @InjectMocks
    private UserService userService;

    @Test
    public void signUp() {
        User newUser = new User("Gasaro Leila", "leila@gmail.com", "pass1234");
        User userExist = new User("John Smith", "smith@gmail.com", "12345678");

        when(userRepositoryMock.findByEmail(newUser.getEmail())).thenReturn(Optional.empty());
        when(userRepositoryMock.save(newUser)).thenReturn(newUser);

        ResponseEntity<?> registerUser = userService.registerUser(newUser);

//        assertTrue("User Already exist!", registerUser.getStatusCode().isError());
        assertTrue((String) registerUser.getBody(),registerUser.getStatusCode().is2xxSuccessful());

    }

//    @Test
//    public void signIn() {
//        User loggedInUser = new User("leila@gmail.com", "123456");
//        User user = new User("Gasaro Leila","leila@gmail.com", "123456");
//        when(userRepositoryMock.findByEmailAndPassword(loggedInUser.getEmail(), loggedInUser.getPassword())).thenReturn(Optional.of(user));
//        assertEquals(Optional.of(user),userService.login(loggedInUser).getBody());
//    }


    @Test
    public void login() {
        LoginRequest loginRequest = new LoginRequest("leila@gmail.com", "pass1234");
        User user = new User("Gasaro Leila", "leila@gmail.com", "pass1234");
        when(userRepositoryMock.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword())).thenReturn(Optional.of(user));

        ResponseEntity<?> loggedInUser = userService.login(loginRequest);
        assertEquals(Optional.of(user), loggedInUser.getBody());

    }

    @Test
    public void login_NotFound() {
        LoginRequest existingUser = new LoginRequest( "leila@gmail.com", "pass1234");
        when(userRepositoryMock.findByEmailAndPassword(existingUser.getEmail(), existingUser.getPassword())).thenReturn(Optional.empty());

        ResponseEntity<?> loggedInUser = userService.login(existingUser);
        assertTrue("Invalid email or password",loggedInUser.getStatusCode().isError());

    }
}
