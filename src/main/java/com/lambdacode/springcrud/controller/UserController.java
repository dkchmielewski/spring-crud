package com.lambdacode.springcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lambdacode.springcrud.dto.UserDTO;
import com.lambdacode.springcrud.entity.User;
import com.lambdacode.springcrud.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl service;
	
	@PostMapping("/add")
	public String addUser(@RequestBody User user) {
		service.addUser(user);
		return "user successfully created";
	}
	
	@GetMapping
	public List<User> getUsers() {
		return service.getUsers();
	}
	
	@GetMapping("/get")
	public User getUser(@RequestParam (name="id") Integer id) {
		return service.getUser(id);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Void> updateUser(@PathVariable (name="id") Integer id, @RequestBody User user) {
		service.updateUser(id, user);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable (name="id") Integer id) {
		service.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
	
	@PatchMapping("/update-name/{id}")
	public ResponseEntity<Void> updateName(@PathVariable (name="id") Integer id, @RequestBody UserDTO userDTO) {
		service.updateName(id, userDTO);
		return ResponseEntity.noContent().build();
	}
	
}
