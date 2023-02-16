package cameleoon.trial.service;

import cameleoon.trial.api.dto.UserRequestDto;
import cameleoon.trial.api.dto.UserResponseDto;
import cameleoon.trial.api.dto.mapper.UserDtoMapper;
import cameleoon.trial.model.UserEntity;
import cameleoon.trial.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	private final UserDtoMapper userDtoMapper;

	public List<UserEntity> getUsers() {
		return userRepository.findAll();
	}


	public UserResponseDto addUser(UserRequestDto request) {

		// todo: fix//
//		userRepository.save(userEntity);
		return userDtoMapper.entityToResponse(userRepository.save(createUser(request)));
	}

	private UserEntity createUser(UserRequestDto request) {
		return UserEntity.builder()
				.name(request.getName())
				.email(request.getEmail())
				.password(request.getPassword())
				.dateOfCreation(LocalDateTime.now())
				.build();
	}



}
