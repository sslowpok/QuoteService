package cameleoon.trial.service;

import cameleoon.trial.api.dto.QuoteRequestDto;
import cameleoon.trial.api.dto.QuoteResponseDto;
import cameleoon.trial.api.dto.StatusResponseDto;
import cameleoon.trial.api.dto.mapper.QuoteDtoMapper;
import cameleoon.trial.exception.QuoteNotFoundException;
import cameleoon.trial.exception.UserNotFoundException;
import cameleoon.trial.model.QuoteEntity;
import cameleoon.trial.model.UserEntity;
import cameleoon.trial.repository.QuoteRepository;
import cameleoon.trial.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuoteServiceImpl implements QuoteService {


	private final QuoteRepository quoteRepository;

	private final UserRepository userRepository;

	private final QuoteDtoMapper quoteDtoMapper;

	@Override
	public List<QuoteResponseDto> getQuotes() {
		List<QuoteResponseDto> res = new ArrayList<>();
		quoteRepository.findAll()
				.forEach(x -> res.add(quoteDtoMapper.entityToResponse(x)));
		return res;
	}

	@Override
	public QuoteResponseDto getQuoteById(Long id) {
		return quoteDtoMapper.entityToResponse(quoteRepository.findById(id)
				.orElseThrow(() -> new QuoteNotFoundException(String.format("Quote with id %s not found", id))));
	}

	@Override
	public QuoteResponseDto addQuote(QuoteRequestDto request) {
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
		QuoteEntity entity = quoteDtoMapper.requestToEntity(request);
		entity.setUserEntity(findUserById(request.getUserId()));
		entity.setTimestamp(LocalDateTime.now());
		return quoteDtoMapper.entityToResponse(quoteRepository.save(entity));
	}

	@Override
	public QuoteResponseDto getRandomQuote() {
		return quoteDtoMapper.entityToResponse(quoteRepository.findById(getRandomNumber(1L, quoteRepository.count()))
				.orElseThrow(() -> new EntityNotFoundException("Quote repository is empty")));
	}

	public Long getRandomNumber(Long min, Long max) {
		Random random = new Random();
		return random.nextLong(max - min + 1) + min;
	}

	@Override
	public StatusResponseDto deleteQuote(Long id) {
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
		List<QuoteEntity> list = quoteRepository.findByOrderByScoreDesc().stream()
				.limit(10).toList();
		List<QuoteResponseDto> res = new ArrayList<>();
		list.forEach(x -> res.add(quoteDtoMapper.entityToResponse(x)));
		return res;
	}

	@Override
	public List<QuoteResponseDto> getLastQuotes() {
		List<QuoteEntity> list = quoteRepository.findByOrderByScoreAsc().stream()
				.limit(10).toList();
		List<QuoteResponseDto> res = new ArrayList<>();
		list.forEach(x -> res.add(quoteDtoMapper.entityToResponse(x)));
		return res;
	}
}
