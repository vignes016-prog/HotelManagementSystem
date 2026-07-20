package com.ty.HotelManagementSystem.Service;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ty.HotelManagementSystem.Repository.BookingRepository;
import com.ty.HotelManagementSystem.Repository.RoomRepository;
import com.ty.HotelManagementSystem.Repository.UserRepository;
import com.ty.HotelManagementSystem.entity.Booking;
import com.ty.HotelManagementSystem.entity.Room;
import com.ty.HotelManagementSystem.entity.User;
@Service
public class BookingService {
@Autowired
private BookingRepository bookingRepository;
@Autowired
private UserRepository userRepository;
@Autowired
private RoomRepository roomRepository;



@Transactional
public Booking bookRoom(int roomId, LocalDate checkInDate,LocalDate checkOutDate, int userId,boolean available)
{
	if(checkInDate==null || checkOutDate == null)
	{
		throw new RuntimeException("checkindate and checkoutdate required");
	}
	if(!checkInDate.isBefore(checkOutDate))
	{
		throw new RuntimeException("CheckInDate must be before checkOutDate");
	}
	User user=userRepository.findById(userId).orElseThrow(()-> new RuntimeException("user not found"));
	
	Room room=roomRepository.findById(roomId).orElseThrow(()-> new RuntimeException("Room not found"));

	if(!room.isAvailable())
	{
		throw new RuntimeException("Room already Booked");
	}

	Booking booking=new Booking();
	booking.setUser(user);
	booking.setRoom(room);
	booking.setCheckInDate(checkInDate);
	booking.setCheckOutDate(checkOutDate);
	booking.setStatus("CONFIRMED");
	long nights = ChronoUnit.DAYS.between(checkInDate, checkOutDate);
	booking.setTotalprice(nights * room.getPricePerNight());

	room.setAvailable(false);
	roomRepository.save(room);
	return bookingRepository.save(booking);
}
public List<Booking>getAllBookings()
{
	return bookingRepository.findAll();
}
public Booking getByid(int bookingid)
{
	return bookingRepository.findById(bookingid).orElseThrow(()->new RuntimeException("booking not found"));
}
public String cancelBooking(int bookingid)
{
	Booking booking=getByid(bookingid);
	booking.setStatus("CANCELLED");
	Room room=booking.getRoom();
	room.setAvailable(true);
	roomRepository.save(room);
	return "Booking calcelled successfully";
}
}
