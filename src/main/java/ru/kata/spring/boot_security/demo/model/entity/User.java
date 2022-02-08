package ru.kata.spring.boot_security.demo.model.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.kata.spring.boot_security.demo.model.entity.Role;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "user")
@NamedEntityGraphs(value = {
		@NamedEntityGraph(
				name = "User.roles",
				attributeNodes = @NamedAttributeNode("roles")
		)
})
public class User implements UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "user_name", nullable = false, unique = true)
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	// @Fetch(FetchMode.JOIN)
	@JoinTable(name = "Users_roles",
			joinColumns = @JoinColumn(name = "users_id"),
			inverseJoinColumns = @JoinColumn(name = "roles_id"))
	private Set<Role> roles = new HashSet<>();
	
	public User() {
	}
	
	public User(Long id, String firstName, String lastName, int age, String username, String password, String email, Set<Role> roles) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.username = username;
		this.password = password;
		this.email = email;
		this.roles = roles;
	}
	
	public User(String firstName, String lastName, int age, String username, String password, String email, Set<Role> roles) {
	
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.username = username;
		this.password = password;
		this.email = email;
		this.roles = roles;
	}
	
	@Override
	public String getUsername() {
		return username;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getRoles();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}
}