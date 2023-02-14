package cameleoon.trial.api.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserRequestDto {

	private String name;

	private String email;

	private LocalDateTime dateOfCreation;

}
