package cameleoon.trial.api.controller;

import cameleoon.trial.api.dto.QuoteRequestDto;
import cameleoon.trial.api.dto.QuoteResponseDto;
import cameleoon.trial.api.dto.StatusResponseDto;
import cameleoon.trial.model.QuoteEntity;
import cameleoon.trial.service.QuoteService;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quotes")
@RequiredArgsConstructor
public class QuoteController {

	private final QuoteService quoteService;

	@GetMapping
	@Schema(description = "Get list of votes")
	public List<QuoteResponseDto> getQuotes() {
		return quoteService.getQuotes();
	}

	@PostMapping
	@Schema(description = "Add new quote")
	public QuoteResponseDto addQuote(@RequestBody QuoteRequestDto request) {
		return quoteService.addQuote(request);
	}

	@PutMapping
	@Schema(description = "Update vote")
	public QuoteResponseDto updateQuote(@RequestBody QuoteRequestDto request) {
		return quoteService.updateQuote(request);
	}

	@GetMapping("/random")
	@Schema(description = "Get a random quote")
	public QuoteResponseDto getRandomQuote() {
		return quoteService.getRandomQuote();
	}

	@GetMapping("/{id}")
	@Schema(description = "Get quote by id")
	public QuoteResponseDto getQuoteById(@PathVariable Long id) {
		return quoteService.getQuoteById(id);
	}

	@DeleteMapping("/{id}")
	public StatusResponseDto deleteQuoteById(@PathVariable Long id) {
		return quoteService.deleteQuote(id);
	}

	@GetMapping("/top")
	public List<QuoteResponseDto> getTopQuotes() {
		return quoteService.getTopQuotes();
	}

	@GetMapping("/last")
	public List<QuoteResponseDto> getLastQuotes() {
		return quoteService.getLastQuotes();
	}

}
