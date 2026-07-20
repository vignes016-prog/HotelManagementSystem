package com.ty.HotelManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.HotelManagementSystem.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
