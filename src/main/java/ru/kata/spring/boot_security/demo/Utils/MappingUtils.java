package ru.kata.spring.boot_security.demo.Utils;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.model.dto.UserDTO;
import ru.kata.spring.boot_security.demo.model.entity.User;

import java.util.Objects;

@Component
public class MappingUtils {
	
	@Autowired
	private ModelMapper mapper;

	public User toEntity(User dto) {
		return Objects.isNull(dto) ? null : mapper.map(dto, User.class);
	}

	public UserDTO toDto(UserDTO entity) {
		return Objects.isNull(entity) ? null : mapper.map(entity, UserDTO.class);
	}
}
