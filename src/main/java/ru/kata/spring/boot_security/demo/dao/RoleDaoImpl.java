package ru.kata.spring.boot_security.demo.dao;


import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.entity.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void createRole(Role role) {
		em.persist(role);
	}
	
	@Override
	public void deleteRole(Long id) {
		em.createQuery("DELETE FROM Role WHERE ID=" + id + ";").executeUpdate();
	}
	
	@Override
	public Role getRoleById(Long id) {
		return em.find(Role.class, id);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Role> getRoles() {
		return em.createQuery("from Role", Role.class).getResultList();
	}
	
}
