package com.ty.HotelManagementSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.HotelManagementSystem.Service.UserService;
import com.ty.HotelManagementSystem.entity.User;

@RestController
@RequestMapping("/api/users")
public class UserController {
@Autowired
private UserService userService;
@PostMapping
public ResponseEntity<User>createuser(@RequestBody User user)
{
	User saveuser=userService.saveUser(user);
	return new ResponseEntity<>(saveuser,HttpStatus.CREATED);
}
@GetMapping
public ResponseEntity<List<User>> getAllUser()
{
	return new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);
}
@GetMapping("/{userId}")
public ResponseEntity<User> getUserById(@PathVariable int userId)
{
	return new ResponseEntity<>(userService.getUserById(userId),HttpStatus.OK);
}
@PutMapping("/{userId}")
public ResponseEntity<User> updateUser(@PathVariable int userId,@RequestBody User user)
{
	return new ResponseEntity<>(userService.updateUser(userId, user),HttpStatus.OK);
}
@DeleteMapping("/{userId}")
public ResponseEntity<String> deleteUser(@PathVariable int userId)
{
	return new ResponseEntity<>(userService.deleteUser(userId),HttpStatus.OK);
}
}
