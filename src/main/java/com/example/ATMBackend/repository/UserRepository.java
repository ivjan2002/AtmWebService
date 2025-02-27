package com.example.ATMBackend.repository;

import com.example.ATMBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
