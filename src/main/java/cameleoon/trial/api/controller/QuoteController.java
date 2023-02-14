package cameleoon.trial.api.controller;

import cameleoon.trial.api.dto.QuoteRequestDto;
import cameleoon.trial.model.QuoteEntity;
import cameleoon.trial.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quotes")
public class QuoteController {

	@Autowired
	private QuoteService quoteService;

	@GetMapping
	public List<QuoteEntity> getQoutes() {
		return quoteService.getQuotes();
	}

	@PostMapping
	public void addQuote(@RequestBody QuoteRequestDto request) {
		quoteService.addOrUpdateQuote(request);
	}

}
