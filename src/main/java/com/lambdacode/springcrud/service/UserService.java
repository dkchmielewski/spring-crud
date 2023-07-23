package com.lambdacode.springcrud.service;

import java.util.List;

import com.lambdacode.springcrud.dto.UserDTO;
import com.lambdacode.springcrud.entity.User;

public interface UserService {
	
	public void addUser(User user);
	
	public List<User> getUsers();
	
	public User getUser(Integer id);
	
	public void updateUser(Integer id, User user);
	
	public void deleteUser(Integer id);
	
	public void updateName(Integer id, UserDTO userDTO);

}
