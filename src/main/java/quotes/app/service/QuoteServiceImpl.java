package quotes.app.service;

import quotes.app.api.dto.QuoteRequestDto;
import quotes.app.api.dto.QuoteResponseDto;
import quotes.app.api.dto.StatusResponseDto;
import quotes.app.api.dto.mapper.QuoteDtoMapper;
import quotes.app.exception.QuoteNotFoundException;
import quotes.app.exception.UserNotFoundException;
import quotes.app.model.QuoteEntity;
import quotes.app.model.UserEntity;
import quotes.app.repository.QuoteRepository;
import quotes.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuoteServiceImpl implements QuoteService {


	private final QuoteRepository quoteRepository;

	private final UserRepository userRepository;

	private final QuoteDtoMapper quoteDtoMapper;

	@Override
	public List<QuoteResponseDto> getQuotes() {
		log.info("Get quotes request");
		List<QuoteResponseDto> res = new ArrayList<>();
		quoteRepository.findAll()
				.forEach(x -> res.add(quoteDtoMapper.entityToResponse(x)));
		return res;
	}

	@Override
	public QuoteResponseDto getQuoteById(Long id) {
		log.info(String.format("Get quote with id %d request", id));
		return quoteDtoMapper.entityToResponse(quoteRepository.findById(id)
				.orElseThrow(() -> new QuoteNotFoundException(String.format("Quote with id %s not found", id))));
	}

	@Override
	public QuoteResponseDto addQuote(QuoteRequestDto request) {
		log.info(String.format("Add quote request: %s", request));
		return quoteDtoMapper.entityToResponse(quoteRepository.save(createQuote(request)));
	}

	private QuoteEntity createQuote(QuoteRequestDto request) {
		QuoteEntity quoteEntity = quoteDtoMapper.requestToEntity(request);
		quoteEntity.setId(null);
		quoteEntity.setUserEntity(findUserById(request.getUserId()));
		quoteEntity.setScore(0);
		return quoteEntity;
	}

	private UserEntity findUserById(Long userid) {
		return userRepository.findById(userid)
				.orElseThrow(() -> new UserNotFoundException(
						String.format("User with id %s not found", userid)
				));
	}

	@Override
	public QuoteResponseDto updateQuote(QuoteRequestDto request) {
		log.info(String.format("Update quote request: %s", request));
		QuoteEntity entity = quoteDtoMapper.requestToEntity(request);
		entity.setUserEntity(findUserById(request.getUserId()));
		entity.setTimestamp(LocalDateTime.now());
		return quoteDtoMapper.entityToResponse(quoteRepository.save(entity));
	}

	@Override
	public QuoteResponseDto getRandomQuote() {
		log.info("Get random quote request");
		return quoteDtoMapper.entityToResponse(quoteRepository.findById(getRandomNumber(1L, quoteRepository.count()))
				.orElseThrow(() -> new EntityNotFoundException("Quote repository is empty")));
	}

	public Long getRandomNumber(Long min, Long max) {
		Random random = new Random();
		return random.nextLong(max - min + 1) + min;
	}

	@Override
	public StatusResponseDto deleteQuote(Long id) {
		log.info(String.format("Delete quote request with id %d", id));
		if (!quoteRepository.existsById(id)) {
			throw new QuoteNotFoundException(String.format("Quote with id %s not found", id));
		}
		quoteRepository.deleteById(id);
		return StatusResponseDto.builder()
				.code(200)
				.desc("Entity deleted successfully")
				.build();
	}

	@Override
	public List<QuoteResponseDto> getTopQuotes() {
		log.info("Get top quotes request");
		List<QuoteEntity> list = quoteRepository.findByOrderByScoreDesc().stream()
				.limit(10).toList();
		List<QuoteResponseDto> res = new ArrayList<>();
		list.forEach(x -> res.add(quoteDtoMapper.entityToResponse(x)));
		return res;
	}

	@Override
	public List<QuoteResponseDto> getLastQuotes() {
		log.info("Get last quotes request");
		List<QuoteEntity> list = quoteRepository.findByOrderByScoreAsc().stream()
				.limit(10).toList();
		List<QuoteResponseDto> res = new ArrayList<>();
		list.forEach(x -> res.add(quoteDtoMapper.entityToResponse(x)));
		return res;
	}
}
