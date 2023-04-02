package cameleoon.trial.service;

import cameleoon.trial.api.dto.UserDetailsResponseDto;
import cameleoon.trial.api.dto.UserRequestDto;
import cameleoon.trial.api.dto.UserResponseDto;
import cameleoon.trial.api.dto.mapper.UserDtoMapper;
import cameleoon.trial.exception.UserNotFoundException;
import cameleoon.trial.model.UserEntity;
import cameleoon.trial.repository.UserRepository;
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
