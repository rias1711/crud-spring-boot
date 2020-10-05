package com.example.demo.service;

import com.example.demo.model.MyUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MyUserService {

    List<MyUser> getAllUsers();

    Optional<MyUser> findUserById(Long id);

    void save(MyUser myUser);

    void delete(Long id);

}
