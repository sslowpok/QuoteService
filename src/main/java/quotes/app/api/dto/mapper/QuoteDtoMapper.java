package quotes.app.api.dto.mapper;

import quotes.app.api.dto.QuoteRequestDto;
import quotes.app.api.dto.QuoteResponseDto;
import quotes.app.model.QuoteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class QuoteDtoMapper {

	public QuoteEntity requestToEntity(QuoteRequestDto request) {
		return QuoteEntity.builder()
				.id(request.getId())
				.content(request.getContent())
				.timestamp(LocalDateTime.now())
				.build();
	}

	public QuoteResponseDto entityToResponse(QuoteEntity quoteEntity) {
		return QuoteResponseDto.builder()
				.id(quoteEntity.getId())
				.content(quoteEntity.getContent())
				.userId(quoteEntity.getUserEntity().getId())
				.timestamp(quoteEntity.getTimestamp())
				.score(quoteEntity.getScore())
				.build();
	}

}
