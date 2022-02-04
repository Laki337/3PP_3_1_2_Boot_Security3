package ru.kata.spring.boot_security.demo.Utils;

import lombok.Data;
import ru.kata.spring.boot_security.demo.model.Role;

import java.util.HashSet;
import java.util.Set;

@Data
public class UserDTO {
	private Long id;
	private String firstName;
	private String lastName;
	private int age;
	private String username;
	private String password;
	private String email;
	private Set<Role> roles = new HashSet<>();
	public UserDTO() {
	}
	
	public UserDTO(Long id, String firstName, String lastName, int age, String username, String password, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public UserDTO(Long id, String firstName, String lastName, int age, String username, String password, String email, Set<Role> roles) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.username = username;
		this.password = password;
		this.email = email;
		this.roles = roles;
	}
}
