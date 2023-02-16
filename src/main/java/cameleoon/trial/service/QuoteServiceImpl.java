package cameleoon.trial.service;

import cameleoon.trial.api.dto.QuoteRequestDto;
import cameleoon.trial.api.dto.QuoteResponseDto;
import cameleoon.trial.api.dto.mapper.QuoteDtoMapper;
import cameleoon.trial.exception.QuoteNotFoundException;
import cameleoon.trial.exception.UserNotFoundException;
import cameleoon.trial.model.QuoteEntity;
import cameleoon.trial.model.UserEntity;
import cameleoon.trial.repository.QuoteRepository;
import cameleoon.trial.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
	public QuoteEntity getQuoteById(Long id) {
		return quoteRepository.findById(id)
				.orElseThrow(() -> new QuoteNotFoundException(String.format("Quote with id %s not found", id)));
	}

	@Override
	@Transactional
	public QuoteResponseDto addQuote(QuoteRequestDto request) {
		UserEntity author = findUserById(request.getUserId());
		QuoteEntity quoteEntity = quoteRepository.save(createQuote(request, author));
		author.getQuoteEntities().add(quoteEntity);

		return quoteDtoMapper.entityToResponse(quoteEntity);
//		return quoteDtoMapper.entityToResponse(quoteRepository.save(createQuote(request, author)));
	}


	private QuoteEntity createQuote(QuoteRequestDto request, UserEntity author) {
		return QuoteEntity.builder()
				.content(request.getContent())
				.userEntity(author)
				.timestamp(LocalDateTime.now())
				.build();
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

	// todo: by id or content? parameter???
	@Override
	public void deleteQuote(Long id) {

	}
}
