package ru.kata.spring.boot_security.demo.model.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "role")
public class Role implements GrantedAuthority {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name_role",nullable = false, unique = true)
	private String nameRole;
	
	@ManyToMany(mappedBy = "roles")
	private Set<User> users;
	
	public Role(String nameRole) {
		this.nameRole = nameRole;
	}
	
	public Role() {
	}
	

	
	@Override
	public String toString() {
		return nameRole;
	}
	
	@Override
	public String getAuthority() {
		return nameRole;
	}
}