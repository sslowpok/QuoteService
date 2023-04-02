package cameleoon.trial.service;

import cameleoon.trial.api.dto.VoteRequestDto;
import cameleoon.trial.api.dto.VoteResponseDto;
import cameleoon.trial.api.dto.mapper.VoteDtoMapper;
import cameleoon.trial.enums.VoteCategory;
import cameleoon.trial.exception.QuoteNotFoundException;
import cameleoon.trial.exception.UserNotFoundException;
import cameleoon.trial.model.QuoteEntity;
import cameleoon.trial.model.UserEntity;
import cameleoon.trial.model.VoteEntity;
import cameleoon.trial.repository.QuoteRepository;
import cameleoon.trial.repository.UserRepository;
import cameleoon.trial.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class VoteServiceImpl implements VoteService {

    private final VoteRepository voteRepository;
    private final QuoteRepository quoteRepository;

    private final UserRepository userRepository;

    private final VoteDtoMapper voteDtoMapper;

    @Override
    public VoteResponseDto addVote(VoteRequestDto request) {
        log.info(String.format("Add vote request: %s", request));
        return voteDtoMapper.entityToResponse(voteRepository.save(createVote(request)));
    }

    @Override
    public List<VoteResponseDto> getVotes() {
        log.info("Get votes request");
        List<VoteResponseDto> votesList = new ArrayList<>();
        voteRepository.findAll().forEach(x -> votesList.add(voteDtoMapper.entityToResponse(x)));
        return votesList;
    }

    private VoteEntity createVote(VoteRequestDto request) {
        UserEntity userEntity = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UserNotFoundException(
                        String.format("User with id %s not found", request.getUserId())
                ));
        QuoteEntity quoteEntity = getQuoteById(request.getQuoteId());
        if (request.getVoteCategory().equals(VoteCategory.UPVOTE)) {
            quoteEntity.setScore(quoteEntity.getScore() + 1);
        } else if (request.getVoteCategory().equals(VoteCategory.DOWNVOTE)) {
            if (quoteEntity.getScore() > 0) {
                quoteEntity.setScore(quoteEntity.getScore() - 1);
            }
        }
        return VoteEntity.builder()
                .quoteEntity(quoteEntity)
                .timestamp(LocalDateTime.now())
                .userEntity(userEntity)
                .voteCategory(request.getVoteCategory())
                .build();
    }

    private QuoteEntity getQuoteById(Long quoteId) {
        log.info(String.format("Get quote by id %d request", quoteId));
        return quoteRepository.findById(quoteId)
                .orElseThrow(() -> new QuoteNotFoundException(String.format("Quote with id %s not found", quoteId)));
    }

}
