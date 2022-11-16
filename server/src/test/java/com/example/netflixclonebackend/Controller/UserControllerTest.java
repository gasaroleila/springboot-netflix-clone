package com.example.netflixclonebackend.Controller;

import com.example.netflixclonebackend.Model.User;
import com.example.netflixclonebackend.Service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @MockBean
    private UserService userServiceMock;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void saveUser_success() {
        User newUser = new User("Gasaro Leila", "leila@gmail.com", "pass1234");
        when(userServiceMock.registerUser(newUser)).thenReturn(newUser);

        ResponseEntity<?> registerUser = userService.registerUser(newUser);
        assertTrue((String) registerUser.getBody(),registerUser.getStatusCode().is2xxSuccessful());
    }

    @Test
    public void saveUser_exists() {
        User userExists = new User("Gasaro Leila", "leila@gmail.com", "pass1234");

        ResponseEntity<?> registerUser = userService.registerUser(userExists);
        assertTrue((String) registerUser.getBody(),registerUser.getStatusCode().is2xxSuccessful());
    }
}
