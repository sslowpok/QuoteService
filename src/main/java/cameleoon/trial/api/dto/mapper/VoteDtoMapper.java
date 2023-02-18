package cameleoon.trial.api.dto.mapper;

import cameleoon.trial.api.dto.VoteResponseDto;
import cameleoon.trial.model.VoteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VoteDtoMapper {

    public VoteResponseDto entityToResponse(VoteEntity voteEntity) {
        return VoteResponseDto.builder()
                .id(voteEntity.getId())
                .quoteId(voteEntity.getQuoteEntity().getId())
                .timestamp(voteEntity.getTimestamp())
                .voteCategory(voteEntity.getVoteCategory())
                .build();
    }

}
