package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.entity.User;

import java.util.List;

public interface UserService {
	List<User> getAllUsers();
	
	void save(User user);
	
	void update(User user);
	
	void delete(Long id);
	
	User getById(long id);
	
}
