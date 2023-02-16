package cameleoon.trial.api.dto.mapper;

import cameleoon.trial.api.dto.UserResponseDto;
import cameleoon.trial.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDtoMapper {

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
