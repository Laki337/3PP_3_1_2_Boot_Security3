package ru.kata.spring.boot_security.demo.model.dto;

import lombok.Data;
import ru.kata.spring.boot_security.demo.model.entity.Role;

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

	

}
