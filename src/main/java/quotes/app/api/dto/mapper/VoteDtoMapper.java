package quotes.app.api.dto.mapper;

import quotes.app.api.dto.VoteResponseDto;
import quotes.app.model.VoteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VoteDtoMapper {

    public VoteResponseDto entityToResponse(VoteEntity voteEntity) {
        return VoteResponseDto.builder()
                .id(voteEntity.getId())
                .quoteId(voteEntity.getQuoteEntity().getId())
                .userId(voteEntity.getUserEntity().getId())
                .timestamp(voteEntity.getTimestamp())
                .voteCategory(voteEntity.getVoteCategory())
                .build();
    }

}
