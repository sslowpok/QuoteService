package quotes.app.service;

import quotes.app.api.dto.QuoteRequestDto;
import quotes.app.api.dto.QuoteResponseDto;
import quotes.app.api.dto.StatusResponseDto;

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
