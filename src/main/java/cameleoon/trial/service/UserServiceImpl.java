package cameleoon.trial.service;

import cameleoon.trial.api.dto.StatusResponseDto;
import cameleoon.trial.model.UserEntity;
import cameleoon.trial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public List<UserEntity> getUsers() {
		return userRepository.findAll();
	}


	public StatusResponseDto addOrUpdateUser(UserEntity userEntity) {
		userEntity.setTimestamp(LocalDateTime.now());

		return null;
	}
}
