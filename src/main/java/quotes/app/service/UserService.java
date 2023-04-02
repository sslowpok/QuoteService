package quotes.app.service;

import quotes.app.api.dto.UserDetailsResponseDto;
import quotes.app.api.dto.UserRequestDto;
import quotes.app.api.dto.UserResponseDto;

import java.util.List;

public interface UserService {
	List<UserResponseDto> getUsers();

	UserDetailsResponseDto getUserById(Long id);
	UserResponseDto addUser(UserRequestDto userRequestDto);
}
