package cameleoon.trial.api.controller;

import cameleoon.trial.api.dto.QuoteRequestDto;
import cameleoon.trial.api.dto.QuoteResponseDto;
import cameleoon.trial.api.dto.StatusResponseDto;
import cameleoon.trial.model.QuoteEntity;
import cameleoon.trial.service.QuoteService;
import io.swagger.v3.oas.annotations.Operation;
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
	@Operation(summary = "Get list of quotes")
	public List<QuoteResponseDto> getQuotes() {
		return quoteService.getQuotes();
	}

	@PostMapping
	@Operation(summary = "Add new quote")
	public QuoteResponseDto addQuote(@RequestBody QuoteRequestDto request) {
		return quoteService.addQuote(request);
	}

	@PutMapping
	@Operation(summary = "Update quote")
	public QuoteResponseDto updateQuote(@RequestBody QuoteRequestDto request) {
		return quoteService.updateQuote(request);
	}

	@GetMapping("/random")
	@Operation(summary = "Get a random quote")
	public QuoteResponseDto getRandomQuote() {
		return quoteService.getRandomQuote();
	}

	@GetMapping("/{id}")
	@Operation(summary = "Get quote by id")
	public QuoteResponseDto getQuoteById(@PathVariable Long id) {
		return quoteService.getQuoteById(id);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Delete quote by id")
	public StatusResponseDto deleteQuoteById(@PathVariable Long id) {
		return quoteService.deleteQuote(id);
	}

	@GetMapping("/top")
	@Operation(summary = "Get top 10 quotes")
	public List<QuoteResponseDto> getTopQuotes() {
		return quoteService.getTopQuotes();
	}

	@GetMapping("/last")
	@Operation(summary = "Get 10 least scorded quotes")
	public List<QuoteResponseDto> getLastQuotes() {
		return quoteService.getLastQuotes();
	}

}
