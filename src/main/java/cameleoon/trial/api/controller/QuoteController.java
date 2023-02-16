package cameleoon.trial.api.controller;

import cameleoon.trial.api.dto.QuoteRequestDto;
import cameleoon.trial.api.dto.QuoteResponseDto;
import cameleoon.trial.model.QuoteEntity;
import cameleoon.trial.service.QuoteService;
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
	public List<QuoteResponseDto> getQuotes() {
		return quoteService.getQuotes();
	}

	@PostMapping
	public QuoteResponseDto addQuote(@RequestBody QuoteRequestDto request) {
		return quoteService.addQuote(request);
	}

	@PutMapping
	public QuoteResponseDto updateQuote(@RequestBody QuoteRequestDto request) {
		return quoteService.updateQuote(request);
	}

}
