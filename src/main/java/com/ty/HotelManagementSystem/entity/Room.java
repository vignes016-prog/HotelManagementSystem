package com.ty.HotelManagementSystem.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name="room_table")
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int roomId;
private int roomNo;
private String roomType;
private boolean Available;
private double PricePerNight;


}
