package quotes.app.api.dto;

import quotes.app.model.QuoteEntity;
import quotes.app.model.VoteEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class UserDetailsResponseDto {

    @Schema(description = "User id")
    private Long id;

    @Schema(description = "User name")
    private String name;

    @Schema(description = "User email")
    private String email;

    @Schema(description = "User password")
    private String password;

    @Schema(description = "Date of user creation / update")
    private LocalDateTime dateOfCreation;

    @Schema(description = "User's quotes")
    private List<QuoteEntity> quoteEntities;

    @Schema(description = "User's votes")
    private List<VoteEntity> voteEntities;

}
