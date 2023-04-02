package quotes.app.api.dto.mapper;

import quotes.app.api.dto.UserDetailsResponseDto;
import quotes.app.api.dto.UserRequestDto;
import quotes.app.api.dto.UserResponseDto;
import quotes.app.model.UserEntity;
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
