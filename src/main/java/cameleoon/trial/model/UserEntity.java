package cameleoon.trial.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "user_entity")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

	@Id
	@SequenceGenerator(
			name = "user_sequence",
			sequenceName = "user_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "user_sequence"
	)
	private Long id;

	@Column
	private String name;

	@Column
	private String email;

	@Column
	private String password;

	@Column
	@Hidden
	private LocalDateTime dateOfCreation;

	@Column
	@JsonManagedReference
	@OneToMany(orphanRemoval = true, mappedBy = "userEntity", fetch = FetchType.LAZY)
	private List<QuoteEntity> quoteEntities;


	@Column
	@JsonManagedReference
	@OneToMany(orphanRemoval = true, mappedBy = "userEntity", fetch = FetchType.LAZY)
	private List<VoteEntity> voteEntities;

}
