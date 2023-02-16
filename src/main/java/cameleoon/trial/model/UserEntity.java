package cameleoon.trial.model;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	@OneToMany(orphanRemoval = true, mappedBy = "id", fetch = FetchType.LAZY)
	private List<QuoteEntity> quoteEntities;

}
