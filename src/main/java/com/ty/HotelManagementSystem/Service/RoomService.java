package com.ty.HotelManagementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.HotelManagementSystem.Repository.RoomRepository;
import com.ty.HotelManagementSystem.entity.Room;
@Service
public class RoomService {
@Autowired
private RoomRepository roomRepository;

public Room saveroom(Room room)
{
	return roomRepository.save(room);
}
public Room getRoomById(int roomid)
{
	return roomRepository.findById(roomid).orElseThrow(()->new RuntimeException("room not found"));
}
public List<Room>getAllRoom()
{
	return roomRepository.findAll();
}
public String deleteRoom(int roomid)
{
	roomRepository.deleteById(roomid);
	return "room has been deleted";
}
public Room updateRoom(int roomid,Room room)
{
	room.setRoomId(roomid);
	return roomRepository.save(room);
}
	
}
