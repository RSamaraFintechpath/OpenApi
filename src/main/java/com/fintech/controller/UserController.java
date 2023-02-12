package com.fintech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fintech.dto.User;
import com.fintech.service.UserService;

@RestController
@RequestMapping("/user/")
public class UserController {

	@Autowired
	private UserService userService;

	public UserController(UserService userService) {

		this.userService = userService;
	}

	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@GetMapping("/get/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.findUserbyId(id);
	}

	@DeleteMapping("/delete")
	public void deleteById(int id) {
		userService.deleteById(id);
	}

	@GetMapping("/findAll")
	public List<User> findAllUsers() {
		return userService.findAllUsers();
	}

}