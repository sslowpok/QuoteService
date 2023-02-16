package cameleoon.trial.service;

import cameleoon.trial.api.dto.UserRequestDto;
import cameleoon.trial.api.dto.UserResponseDto;
import cameleoon.trial.model.UserEntity;

import java.util.List;

public interface UserService {
	List<UserEntity> getUsers();
	UserResponseDto addUser(UserRequestDto userRequestDto);
}
