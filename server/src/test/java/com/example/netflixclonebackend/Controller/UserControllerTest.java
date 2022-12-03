package com.example.netflixclonebackend.Controller;

import com.example.netflixclonebackend.Model.User;
import com.example.netflixclonebackend.Service.UserService;
import com.example.netflixclonebackend.utils.LoginRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.security.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class, excludeAutoConfiguration = {SecurityAutoConfiguration.class})
public class UserControllerTest {

    @MockBean
    private UserService userServiceMock;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void saveUser_success() throws Exception {
        User newUser = new User("Gasaro Leila", "leila@gmail.com", "pass1234");
        String userJson = new ObjectMapper().writeValueAsString(newUser);
        ResponseEntity<String> saveUser = ResponseEntity.status(HttpStatus.OK).body("User registered successfully");
        when(userServiceMock.registerUser(newUser)).thenReturn(saveUser);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/register")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(userJson);


        MvcResult result = mockMvc
                .perform(request.with(csrf()))
                .andExpect(status().isOk())
                .andReturn();



    }

    @Test
    public void saveUser_exists() {
        User userExists = new User("Gasaro Leila", "leila@gmail.com", "pass1234");

        ResponseEntity<?> registerUser = userServiceMock.registerUser(userExists);
        assertTrue((String) registerUser.getBody(),registerUser.getStatusCode().is2xxSuccessful());
    }

    @Test
    public void login_success() throws Exception {
        LoginRequest userDetails = new LoginRequest("leila@gmail.com", "pass1234");
        String userDetailsJson = new ObjectMapper().writeValueAsString(userDetails);
        User loggedInUser = new User("Gasaro Leila", "leila@gmail.com", "pass1234");
        ResponseEntity<?> savedUser = ResponseEntity.ok().body(loggedInUser);
        when(userServiceMock.login(userDetails)).thenReturn(savedUser);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(userDetailsJson);


        MvcResult result = mockMvc
                .perform(request.with(csrf()))
                .andExpect(status().isOk())
                .andReturn();
    }
}
