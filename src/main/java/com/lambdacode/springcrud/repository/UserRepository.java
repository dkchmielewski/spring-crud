package com.lambdacode.springcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lambdacode.springcrud.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
