package ru.kata.spring.boot_security.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.Date;
import java.util.List;

@Component
public interface RoleDao {
	void createRole(Role role);
	void deleteRole(Long id);
	Role getRoleById(Long id);
	List<Role> getRoles();
}
