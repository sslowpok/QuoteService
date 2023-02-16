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
	@JsonManagedReference
	@OneToMany(orphanRemoval = true, mappedBy = "userEntity", fetch = FetchType.LAZY)
	private List<QuoteEntity> quoteEntities;

}
