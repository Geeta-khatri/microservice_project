package com.UserService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UserService.Entity.Users;

public interface UserRepo extends JpaRepository<Users, Integer>{

}
