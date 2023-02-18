package cameleoon.trial.api.dto;

import cameleoon.trial.enums.VoteCategory;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class VoteResponseDto {

    private Long id;

    private Long quoteId;

    private Long userId;

    private LocalDateTime timestamp;

    private VoteCategory voteCategory;

}
