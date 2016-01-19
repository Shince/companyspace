package com.lovematch.match.jpa.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.lovematch.match.jpa.entity.User;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
   User findUserByNameAndPsw(String name,String pwd);
   User findUserByName(String name);
}
