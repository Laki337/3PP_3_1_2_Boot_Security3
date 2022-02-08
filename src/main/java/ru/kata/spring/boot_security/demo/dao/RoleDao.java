package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.entity.Role;

import java.util.List;

@Component
public interface RoleDao {
	void createRole(Role role);
	void deleteRole(Long id);
	Role getRoleById(Long id);
	List<Role> getRoles();
}
