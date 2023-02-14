package cameleoon.trial.api.dto.mapper;

import cameleoon.trial.api.dto.QuoteResponseDto;
import cameleoon.trial.model.QuoteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuoteResponseDtoMapper {

	public QuoteResponseDto map(QuoteEntity quoteEntity) {
		return QuoteResponseDto.builder()
				.id(quoteEntity.getId())
				.content(quoteEntity.getContent())
				.userId(quoteEntity.getUserEntity().getId())
				.timestamp(quoteEntity.getTimestamp())
				.build();
	}

}
