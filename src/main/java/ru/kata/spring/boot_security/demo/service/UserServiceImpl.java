package ru.kata.spring.boot_security.demo.service;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.User;


import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {
	private final UserDao userRepository;
	private final PasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserDao userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.getUsers();
	}
	
	@Override
	public void save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.createUser(user);
	}
	
	@Override
	public void update(User user) {
		if(userRepository.getUserById(user.getId()).getPassword().equals(user.getPassword())) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
		}
		userRepository.createUser(user);
	}
	
	@Override
	public void delete(Long id) {
		userRepository.deleteUser(id);
	}
	
	@Override
	public User getById(long id) {
		return userRepository.getUserById(id);
	}
	

}