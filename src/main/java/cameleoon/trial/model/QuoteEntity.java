package cameleoon.trial.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
@Table(name = "quote")
@RequiredArgsConstructor
public class QuoteEntity {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String content;

	@Column
	private LocalDateTime timestamp;

	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private UserEntity userEntity;

	// todo: add link to votes

}
