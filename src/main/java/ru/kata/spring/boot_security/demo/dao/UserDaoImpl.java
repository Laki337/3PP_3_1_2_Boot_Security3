package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {
	
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager em;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		return em.createQuery("from User", User.class).getResultList();
	}
	
	@Override
	public void createUser(User user) {
		em.persist(user);
	}
	
	
	@Override
	public User getUserById(Long id) {
		return em.find(User.class, id);
	}
	
	@Override
	public User getUserByUsername(String username) {
		return em.createQuery(
				"SELECT u from User u WHERE u.username = :username", User.class).
				setParameter("username", username).getSingleResult();
	}
	
	@Override
	public void updateUser(User user) {
		em.merge(user);
	}
	
	@Override
	public void deleteUser(Long id) {
		em.createQuery("DELETE FROM User WHERE ID=" + id + ";").executeUpdate();
	}
	
	
}
