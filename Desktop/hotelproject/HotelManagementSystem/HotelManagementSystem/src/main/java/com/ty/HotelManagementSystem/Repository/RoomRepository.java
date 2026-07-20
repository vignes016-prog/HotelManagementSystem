package com.ty.HotelManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.HotelManagementSystem.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {

}
