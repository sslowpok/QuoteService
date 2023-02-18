package cameleoon.trial.model;

import cameleoon.trial.enums.VoteCategory;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
@Table(name = "vote")
@NoArgsConstructor
@AllArgsConstructor
public class VoteEntity {

    @Id
    @Column
    @SequenceGenerator(
            name = "vote_sequence",
            sequenceName = "vote_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "vote_sequence"
    )
    private Long id;

    @ManyToOne(optional = false)
    @JsonBackReference
    @JoinColumn(name = "quote_id", referencedColumnName = "id")
    private QuoteEntity quoteEntity;

    @ManyToOne(optional = false)
    @JsonBackReference
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity userEntity;

    private LocalDateTime timestamp;

    private VoteCategory voteCategory;

}
