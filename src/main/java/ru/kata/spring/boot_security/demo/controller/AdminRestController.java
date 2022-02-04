package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class AdminRestController {
	private final UserService userService;
	private final RoleService roleService;
	
	public AdminRestController(UserService userService, RoleService roleService) {
		this.userService = userService;
		this.roleService = roleService;
	}
	
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		System.err.println(userService.getAllUsers());
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		return userService.getById(id) == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
	}
	
	@GetMapping("/roles")
	public ResponseEntity<List<Role>> getAllRoles() {
		List<Role> roles = roleService.getRoles();
		return new ResponseEntity<>(roles, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		userService.update(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	
	@PostMapping(value = "")
	public ResponseEntity<User> addNewUser(@RequestBody User user) {
		userService.save(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable Long id) {
		userService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
