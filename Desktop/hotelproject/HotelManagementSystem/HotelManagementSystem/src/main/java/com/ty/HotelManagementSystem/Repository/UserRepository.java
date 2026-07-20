package com.ty.HotelManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.HotelManagementSystem.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
