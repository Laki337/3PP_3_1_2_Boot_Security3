package ru.kata.spring.boot_security.demo.Utils;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.kata.spring.boot_security.demo.model.dto.UserDTO;
import ru.kata.spring.boot_security.demo.model.entity.User;

@Mapper
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );
	
	@Mapping(source = "user", target = "id")
	UserDTO userToUserDTO(User user);
	
}
