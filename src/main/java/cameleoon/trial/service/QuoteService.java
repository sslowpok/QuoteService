package cameleoon.trial.service;

import cameleoon.trial.api.dto.QuoteRequestDto;
import cameleoon.trial.api.dto.QuoteResponseDto;
import cameleoon.trial.model.QuoteEntity;

import java.util.List;

public interface QuoteService {

	List<QuoteResponseDto> getQuotes();

	QuoteResponseDto getQuoteById(Long id);

	void deleteQuote(Long id);

	QuoteResponseDto addQuote(QuoteRequestDto request);

	QuoteResponseDto updateQuote(QuoteRequestDto request);

    QuoteResponseDto getRandomQuote();
}
