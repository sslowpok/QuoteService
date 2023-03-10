package cameleoon.trial.service;

import cameleoon.trial.api.dto.UserDetailsResponseDto;
import cameleoon.trial.api.dto.UserRequestDto;
import cameleoon.trial.api.dto.UserResponseDto;

import java.util.List;

public interface UserService {
	List<UserResponseDto> getUsers();

	UserDetailsResponseDto getUserById(Long id);
	UserResponseDto addUser(UserRequestDto userRequestDto);
}
