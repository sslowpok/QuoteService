package cameleoon.trial.api.dto;

import cameleoon.trial.enums.VoteCategory;
import cameleoon.trial.model.QuoteEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class VoteResponseDto {

    private Long id;

    private Long quoteId;

    private LocalDateTime timestamp;

    private VoteCategory voteCategory;

}
