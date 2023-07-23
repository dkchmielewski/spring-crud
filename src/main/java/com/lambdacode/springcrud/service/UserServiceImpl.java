package com.lambdacode.springcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lambdacode.springcrud.dto.UserDTO;
import com.lambdacode.springcrud.entity.User;
import com.lambdacode.springcrud.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;
	
	@Override
	public void addUser(User user) {
		repository.save(user);
	}
	
	@Override
	public List<User> getUsers() {
		return repository.findAll();
	}
	
	@Override
	public User getUser(Integer id) {
		User user = repository
				.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id " + id));
		return user;
	}
	
	@Override
	public void updateUser(Integer id, User user) {
		//check weather the user is in database
		repository
			.findById(id)
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id " + id));
		
		user.setId(id);
		repository.save(user);
	}
	
	@Override
	public void deleteUser(Integer id) {
		User user = repository
			.findById(id)
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id " + id));
		
		repository.delete(user);
	}
	
	@Override 
	public void updateName(Integer id, UserDTO userDTO) {
		User user = repository
				.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id " + id));
		
		user.setName(userDTO.getName());
		repository.save(user);
	}
	
}
