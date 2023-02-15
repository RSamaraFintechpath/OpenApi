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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/user/")
public class UserController {

	@Autowired
	private UserService userService;

	public UserController(UserService userService) {

		this.userService = userService;
	}

	@ApiOperation(value = "add's a user and saves it to the database", notes = "saves to h2 database which will be wiped clean if you restart the API")
	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@ApiOperation(value = "get a user by id", notes = "saves to h2 database which will be wiped clean if you restart the API")
	@ApiParam(value = "the id that you insterted previously in the add endpoint", required = true)
	@GetMapping("/get/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.findUserbyId(id);
	}

	@ApiOperation(value = "deletes a user by his id", notes = "saves to h2 database which will be wiped clean if you restart the API")
	@DeleteMapping("/delete")
	@ApiParam(value = "id that was previously insterted", required = true)
	public void deleteById(int id) {
		userService.deleteById(id);
	}

	@ApiOperation(value = "retrieves a list of all users", notes = "saves to h2 database which will be wiped clean if you restart the API")
	@GetMapping("/findAll")
	public List<User> findAllUsers() {
		return userService.findAllUsers();
	}

}
