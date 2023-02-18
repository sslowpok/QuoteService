package cameleoon.trial.api.dto;

import cameleoon.trial.model.QuoteEntity;
import cameleoon.trial.model.VoteEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class UserDetailsResponseDto {

    private Long id;

    private String name;

    private String email;

    private String password;

    private LocalDateTime dateOfCreation;

    private List<QuoteEntity> quoteEntities;

    private List<VoteEntity> voteEntities;

}
