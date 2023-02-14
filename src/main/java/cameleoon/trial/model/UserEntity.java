package cameleoon.trial.model;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "user_entity")
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
	private LocalDateTime timestamp;

	@Column
	@OneToMany(orphanRemoval = true, mappedBy = "content", fetch = FetchType.LAZY)
	private List<QuoteEntity> quoteEntities;

}
