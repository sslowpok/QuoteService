package cameleoon.trial.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
@Table(name = "quote")
@NoArgsConstructor
@AllArgsConstructor
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
	@JsonBackReference
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private UserEntity userEntity;

	// todo: add link to votes

}
