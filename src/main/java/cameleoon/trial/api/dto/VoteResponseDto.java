package cameleoon.trial.api.dto;

import cameleoon.trial.enums.VoteCategory;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class VoteResponseDto {

    @Schema(description = "Vote id")
    private Long id;

    @Schema(description = "Id of the quote to vote")
    private Long quoteId;

    @Schema(description = "Id of the vote author")
    private Long userId;

    @Schema(description = "Time of vote creation")
    private LocalDateTime timestamp;

    @Schema(description = "Vote category")
    private VoteCategory voteCategory;

}
