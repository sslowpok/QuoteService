package cameleoon.trial.service;

import cameleoon.trial.api.dto.VoteResponseDto;
import cameleoon.trial.api.dto.mapper.VoteDtoMapper;
import cameleoon.trial.enums.VoteCategory;
import cameleoon.trial.exception.QuoteNotFoundException;
import cameleoon.trial.model.QuoteEntity;
import cameleoon.trial.model.VoteEntity;
import cameleoon.trial.repository.QuoteRepository;
import cameleoon.trial.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VoteServiceImpl implements VoteService {

    private final VoteRepository voteRepository;
    private final QuoteRepository quoteRepository;

    private final VoteDtoMapper voteDtoMapper;

    @Override
    public VoteResponseDto addVote(Long quoteId, VoteCategory voteCategory) {
        return voteDtoMapper.entityToResponse(voteRepository.save(createVote(quoteId, voteCategory)));
    }

    @Override
    public List<VoteResponseDto> getVotes() {
        List<VoteResponseDto> votesList = new ArrayList<>();
        voteRepository.findAll().forEach(x -> votesList.add(voteDtoMapper.entityToResponse(x)));
        return votesList;
    }

    private VoteEntity createVote(Long quoteId, VoteCategory voteCategory) {
        QuoteEntity quoteEntity = getQuoteById(quoteId);
        if (voteCategory.equals(VoteCategory.UPVOTE)) {
            quoteEntity.setScore(quoteEntity.getScore() + 1);
        } else if (voteCategory.equals(VoteCategory.DOWNVOTE)) {
            if (quoteEntity.getScore() > 0) {
                quoteEntity.setScore(quoteEntity.getScore() - 1);
            }
        }
        return VoteEntity.builder()
                .quoteEntity(quoteEntity)
                .timestamp(LocalDateTime.now())
                .voteCategory(voteCategory)
                .build();
    }

    private QuoteEntity getQuoteById(Long quoteId) {
        return quoteRepository.findById(quoteId)
                .orElseThrow(() -> new QuoteNotFoundException(String.format("Quote with id %s not found", quoteId)));
    }

}
