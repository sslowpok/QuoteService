package cameleoon.trial.api.dto;

import cameleoon.trial.enums.VoteCategory;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VoteRequestDto {

    @Schema(description = "Id of the quote to vote", example = "1")
    private Long quoteId;

    @Schema(description = "Id of the vote author", example = "1")
    private Long userId;

    @Schema(description = "Vote category", example = "UPVOTE")
    private VoteCategory voteCategory;

}
