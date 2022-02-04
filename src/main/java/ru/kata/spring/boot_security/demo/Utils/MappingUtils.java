package ru.kata.spring.boot_security.demo.Utils;

import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.model.User;

@Service
public class MappingUtils {
	
	public UserDTO mapToUserDTO(User user){
		return new UserDTO(user.getId(),user.getFirstName(),user.getLastName(),user.getAge(),user.getUsername(),user.getPassword(),user.getEmail(),user.getRoles());
	}
	public User mapToUser(UserDTO userDTO){
		return new User(userDTO.getId(),userDTO.getFirstName(),userDTO.getLastName(),userDTO.getAge(), userDTO.getUsername(),userDTO.getPassword(),userDTO.getEmail(),userDTO.getRoles());
	}
}
