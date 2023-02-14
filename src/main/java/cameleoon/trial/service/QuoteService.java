package cameleoon.trial.service;

import cameleoon.trial.api.dto.QuoteRequestDto;
import cameleoon.trial.api.dto.QuoteResponseDto;
import cameleoon.trial.model.QuoteEntity;

import java.util.List;

public interface QuoteService {

	QuoteResponseDto addOrUpdateQuote(QuoteRequestDto request);

	List<QuoteEntity> getQuotes();

	QuoteEntity getQuoteById(Long id);

	void deleteQuote(Long id);

}
