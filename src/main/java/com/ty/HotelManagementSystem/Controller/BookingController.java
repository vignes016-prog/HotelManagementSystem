package com.ty.HotelManagementSystem.Controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.HotelManagementSystem.Service.BookingService;
import com.ty.HotelManagementSystem.entity.Booking;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
@Autowired
private BookingService bookingService;
@PostMapping
public ResponseEntity<Booking> bookRoom(@RequestParam int roomId,@RequestParam int userId,@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate checkInDate,
		@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate checkOutDate)
{
	Booking booking=bookingService.bookRoom(roomId, checkInDate, checkOutDate, userId, false);
	return new ResponseEntity<>(booking,HttpStatus.CREATED);
}
@GetMapping
public ResponseEntity<List<Booking>> getAllBooking()
{
	return new ResponseEntity<>(bookingService.getAllBookings(),HttpStatus.OK);
}
@GetMapping("/{bookingId}")
public ResponseEntity<Booking>getRoomById(@PathVariable int bookingId)
{
	return new ResponseEntity<>(bookingService.getByid(bookingId),HttpStatus.OK);
}
@PutMapping("/{bookingId}/cancel")
public ResponseEntity<String>cancelBooking(@PathVariable int bookingId)
{
	return new ResponseEntity<>(bookingService.cancelBooking(bookingId),HttpStatus.OK);
}
}
