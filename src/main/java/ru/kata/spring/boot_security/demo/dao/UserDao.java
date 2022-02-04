package ru.kata.spring.boot_security.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;


public interface UserDao {
	void createUser(User user);
	User getUserById(Long id);
	User getUserByUsername(String username);
	void updateUser(User user);
	void deleteUser(Long id);
	List<User> getUsers();
}
