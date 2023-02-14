package cameleoon.trial.model.mapper;

import cameleoon.trial.api.dto.QuoteRequestDto;
import cameleoon.trial.model.QuoteEntity;
import cameleoon.trial.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class QuoteEntityMapper {

	public QuoteEntity map(QuoteRequestDto request, UserEntity user) {
		return QuoteEntity.builder()
				.id(request.getId())
				.content(request.getContent())
				.timestamp(LocalDateTime.now())
				.userEntity(user)
				.build();
	}

}
