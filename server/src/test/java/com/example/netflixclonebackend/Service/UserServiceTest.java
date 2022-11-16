package com.example.netflixclonebackend.Service;

import com.example.netflixclonebackend.Model.User;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.example.netflixclonebackend.Repository.UserRepository;
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
        User newUser = new User("Gasaro Leila", "leila@gmail.com", "123456");
       when(userRepositoryMock.save(newUser)).thenReturn(newUser);

        ResponseEntity<?> registerUser = userService.registerUser(newUser);
        assertTrue(registerUser.getStatusCode().is2xxSuccessful());
    }

    @Test
    public void signIn() {
        User loggedInUser = new User("leila@gmail.com", "123456");
        User user = new User("Gasaro Leila","leila@gmail.com", "123456");
        when(userRepositoryMock.findByEmailAndPassword(loggedInUser.getEmail(), loggedInUser.getPassword())).thenReturn(Optional.of(user));
        assertEquals(Optional.of(user),userService.login(loggedInUser).getBody());
    }
}
