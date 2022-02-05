package com.example.pptaskspringboot.rest.dao;

import com.example.pptaskspringboot.rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepozitory extends JpaRepository<User, Long> {
    User findAllByEmail(String email);
}
