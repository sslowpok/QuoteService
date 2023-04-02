package quotes.app.service;

import quotes.app.api.dto.UserDetailsResponseDto;
import quotes.app.api.dto.UserRequestDto;
import quotes.app.api.dto.UserResponseDto;
import quotes.app.api.dto.mapper.UserDtoMapper;
import quotes.app.exception.UserNotFoundException;
import quotes.app.model.UserEntity;
import quotes.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	private final UserDtoMapper userDtoMapper;

	public List<UserResponseDto> getUsers() {
		log.info("Get users request");
		List<UserResponseDto> res = new ArrayList<>();
		userRepository.findAll().forEach(x -> res.add(userDtoMapper.entityToResponse(x)));
		return res;
	}


	public UserResponseDto addUser(UserRequestDto request) {
		log.info(String.format("Add user request: %s", request));
		return userDtoMapper.entityToResponse(userRepository.save(createUser(request)));
	}

	private UserEntity createUser(UserRequestDto request) {
		return userDtoMapper.requestToEntity(request);
	}

	public UserDetailsResponseDto getUserById(Long id) {
		return userDtoMapper.entityToDetails(userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException(
						String.format("User with id %s not found", id)
				)));
	}
}
