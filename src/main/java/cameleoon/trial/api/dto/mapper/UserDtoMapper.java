package cameleoon.trial.api.dto.mapper;

import cameleoon.trial.api.dto.UserDetailsResponseDto;
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
				.dateOfCreation(userEntity.getDateOfCreation())
				.build();
	}

	public UserDetailsResponseDto entityToDetails(UserEntity userEntity) {
		return UserDetailsResponseDto.builder()
				.id(userEntity.getId())
				.name(userEntity.getName())
				.email(userEntity.getEmail())
				.password(userEntity.getPassword())
				.dateOfCreation(userEntity.getDateOfCreation())
				.quoteEntities(userEntity.getQuoteEntities())
				.voteEntities(userEntity.getVoteEntities())
				.build();
	}

}
