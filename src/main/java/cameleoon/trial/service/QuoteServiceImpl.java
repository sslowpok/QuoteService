package cameleoon.trial.service;

import cameleoon.trial.api.dto.QuoteRequestDto;
import cameleoon.trial.api.dto.QuoteResponseDto;
import cameleoon.trial.api.dto.mapper.QuoteResponseDtoMapper;
import cameleoon.trial.exception.QuoteNotFoundException;
import cameleoon.trial.exception.UserNotFoundException;
import cameleoon.trial.model.QuoteEntity;
import cameleoon.trial.model.UserEntity;
import cameleoon.trial.model.mapper.QuoteEntityMapper;
import cameleoon.trial.repository.QuoteRepository;
import cameleoon.trial.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuoteServiceImpl implements QuoteService {


	private final QuoteRepository quoteRepository;

	private final UserRepository userRepository;

	private final QuoteEntityMapper quoteEntityMapper;

	private final QuoteResponseDtoMapper quoteResponseDtoMapper;


	@Override
	public List<QuoteEntity> getQuotes() {
		return quoteRepository.findAll();
	}

	@Override
	public QuoteEntity getQuoteById(Long id) {
		return quoteRepository.findById(id)
				.orElseThrow(() -> new QuoteNotFoundException(String.format("Quote with id %s not found", id)));
	}

	@Override
	public QuoteResponseDto addOrUpdateQuote(QuoteRequestDto request) {
		UserEntity userEntity = userRepository.findById(request.getUserId())
				.orElseThrow(() -> new UserNotFoundException(String.format("User with id %s not found", request.getUserId())));
		QuoteEntity quoteEntity = request.getId() == null ?
				createQuote(request, userEntity) : updateQuote(request, userEntity);
		return quoteResponseDtoMapper.map(quoteRepository.save(quoteEntity));
	}

	private QuoteEntity createQuote(QuoteRequestDto request, UserEntity user) {
		return quoteEntityMapper.map(request, user);
	}

	private QuoteEntity updateQuote(QuoteRequestDto request, UserEntity userEntity) {
		QuoteEntity quoteEntity = getQuoteById(request.getId());
		quoteEntity.setContent(request.getContent());
		quoteEntity.setUserEntity(userEntity);
		return quoteEntity;
	}


	// todo: by id or content? parameter???
	@Override
	public void deleteQuote(Long id) {

	}
}
