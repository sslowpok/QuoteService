package cameleoon.trial.api.dto.mapper;

import cameleoon.trial.api.dto.UserRequestDto;
import cameleoon.trial.api.dto.UserResponseDto;
import cameleoon.trial.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class UserDtoMapper {

	public UserEntity requestToEntity(UserRequestDto request) {
		return UserEntity.builder()
				.name(request.getName())
				.email(request.getEmail())
				.password(request.getPassword())
				.dateOfCreation(LocalDateTime.now())
				.build();
	}

	public UserResponseDto entityToResponse(UserEntity userEntity) {
		return UserResponseDto.builder()
				.id(userEntity.getId())
				.name(userEntity.getName())
				.email(userEntity.getEmail())
				.password(userEntity.getPassword())
				.dateOfCreation(userEntity.getDateOfCreation())
				.build();
	}

}
