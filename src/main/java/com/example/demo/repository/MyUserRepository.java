package com.example.demo.repository;

import com.example.demo.model.MyUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepository extends CrudRepository<MyUser, Long> {
}
