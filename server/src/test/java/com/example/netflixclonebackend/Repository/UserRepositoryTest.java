package com.example.netflixclonebackend.Repository;

import com.example.netflixclonebackend.Model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByEmailAndPassword() {
      Optional<User> user = userRepository.findByEmailAndPassword("leila@gmail.com","123456");
      assertTrue(user.isPresent());
    }


}
