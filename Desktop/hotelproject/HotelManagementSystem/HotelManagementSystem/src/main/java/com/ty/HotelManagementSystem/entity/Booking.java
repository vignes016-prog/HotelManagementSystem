package com.ty.HotelManagementSystem.entity;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Booking {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int bookingId;
@ManyToOne
@JoinColumn(name = "roomid",nullable = false)
private Room room;

@ManyToOne
@JoinColumn(name = "userid",nullable = false)
private User user;
	
private LocalDate checkInDate;
private LocalDate checkOutDate;
private double totalprice;
private String status;

}
