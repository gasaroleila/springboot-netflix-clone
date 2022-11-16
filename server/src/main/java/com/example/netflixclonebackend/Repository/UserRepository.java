package com.example.netflixclonebackend.Repository;

import com.example.netflixclonebackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByEmailAndPassword(String email, String password);
}
