package cameleoon.trial.service;

import cameleoon.trial.api.dto.QuoteRequestDto;
import cameleoon.trial.api.dto.QuoteResponseDto;
import cameleoon.trial.api.dto.StatusResponseDto;
import cameleoon.trial.model.QuoteEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuoteService {

	List<QuoteResponseDto> getQuotes();

	QuoteResponseDto getQuoteById(Long id);

	StatusResponseDto deleteQuote(Long id);

	QuoteResponseDto addQuote(QuoteRequestDto request);

	QuoteResponseDto updateQuote(QuoteRequestDto request);

    QuoteResponseDto getRandomQuote();

	List<QuoteResponseDto> getTopQuotes();

	List<QuoteResponseDto> getLastQuotes();

}
