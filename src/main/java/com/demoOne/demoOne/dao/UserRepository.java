package com.demoOne.demoOne.dao;

import org.springframework.data.repository.CrudRepository;

import com.demoOne.demoOne.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    public User findById(int id);
}