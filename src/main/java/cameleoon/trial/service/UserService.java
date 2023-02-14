package cameleoon.trial.service;

import cameleoon.trial.api.dto.StatusResponseDto;
import cameleoon.trial.model.UserEntity;

import java.util.List;

public interface UserService {
	List<UserEntity> getUsers();
	StatusResponseDto addOrUpdateUser(UserEntity userEntity);
}
