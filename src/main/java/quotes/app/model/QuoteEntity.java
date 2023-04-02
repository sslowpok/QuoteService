package quotes.app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "quote")
@NoArgsConstructor
@AllArgsConstructor
public class QuoteEntity {

	@Id
	@Column
	@SequenceGenerator(
			name = "quote_sequence",
			sequenceName = "quote_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "quote_sequence"
	)
	private Long id;

	@Column
	private String content;

	@Column
	private LocalDateTime timestamp;

	@ManyToOne(optional = false)
	@JsonBackReference
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private UserEntity userEntity;

	private Integer score;

	@Column
	@JsonManagedReference
	@OneToMany(orphanRemoval = true, mappedBy = "quoteEntity", fetch = FetchType.LAZY)
	private List<VoteEntity> voteEntities;

}
