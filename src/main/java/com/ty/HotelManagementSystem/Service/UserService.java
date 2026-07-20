package com.ty.HotelManagementSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ty.HotelManagementSystem.entity.User;
import java.util.List;

import com.ty.HotelManagementSystem.Repository.UserRepository;
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(User user) {
        return userRepository.save(user);
    }
	public User getUserById(int userid)
	{
		return userRepository.findById(userid).orElseThrow(()-> new RuntimeException("user not found"));
	}
	public List <User> getAllUser()
	{
		return userRepository.findAll();
	}
	public String deleteUser(int userid)
	{
		userRepository.deleteById(userid);
		return "user has been deleted";
	}
	public User updateUser(int userId,User user) {
		user.setUserId(userId);
		return userRepository.save(user);
	}
}
