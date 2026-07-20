package com.ty.HotelManagementSystem.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.HotelManagementSystem.Service.RoomService;
import com.ty.HotelManagementSystem.entity.Room;



@RestController
@RequestMapping("/api/rooms")
public class RoomController {
@Autowired
private RoomService roomService;

@PostMapping
public ResponseEntity<Room>addRoom(@RequestBody Room room)
{
	Room saveroom=roomService.saveroom(room);
   return new ResponseEntity<>(saveroom,HttpStatus.CREATED);
}
@GetMapping
public ResponseEntity<List<Room>> getAllRoom()
{
	return new ResponseEntity<>(roomService.getAllRoom(),HttpStatus.OK);
}
@GetMapping("/{roomId}")
public ResponseEntity<Room> getRoomById(@PathVariable int roomId)
{
	return new ResponseEntity<>(roomService.getRoomById(roomId),HttpStatus.OK);
	
}
@PutMapping("/{roomId}")
public ResponseEntity<Room>updateRoom(@PathVariable int roomId,@RequestBody Room room)
{
	return new ResponseEntity<>(roomService.updateRoom(roomId, room),HttpStatus.OK);
}

@DeleteMapping("/{roomId}")
public ResponseEntity<String> deleteRoom(@PathVariable int roomId) {
    return new ResponseEntity<>(roomService.deleteRoom(roomId), HttpStatus.OK);
}

}

