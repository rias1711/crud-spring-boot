package com.example.demo.service;

import com.example.demo.model.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.repository.MyUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyUserServiceImpl implements MyUserService {
    @Autowired
    private MyUserRepository myUserRepository;

    @Override
    public List<MyUser> getAllUsers() {
        return (List<MyUser>) myUserRepository.findAll();
    }

    @Override
    public Optional<MyUser> findUserById(Long id) {
        return myUserRepository.findById(id);
    }

    @Override
    public void save(MyUser myUser) {
        myUserRepository.save(myUser);
    }

    @Override
    public void delete(Long id) {
        myUserRepository.deleteById(id);
    }
}
