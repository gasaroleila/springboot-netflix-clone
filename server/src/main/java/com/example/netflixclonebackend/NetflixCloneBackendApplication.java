package com.example.netflixclonebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
public class NetflixCloneBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetflixCloneBackendApplication.class, args);
    }

}
