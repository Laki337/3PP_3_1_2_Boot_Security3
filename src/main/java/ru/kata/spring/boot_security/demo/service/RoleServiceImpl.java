package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.model.entity.Role;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{
	
	private final RoleDao roleRepository;
	
	public RoleServiceImpl(RoleDao roleDao) {
		this.roleRepository = roleDao;
	}
	
	@Override
	public void createRole(Role role) {
		roleRepository.createRole(role);
	}
	
	@Override
	public Role getRoleById(Long id) {
		return roleRepository.getRoleById(id);
	}
	
	@Override
	public void updateRole(Role role) {
		roleRepository.createRole(role);
	}
	
	@Override
	public void deleteRole(Long id) {
		roleRepository.deleteRole(id);
	}
	
	@Override
	public List<Role> getRoles() {
		return roleRepository.getRoles();
	}

}
