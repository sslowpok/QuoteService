package cameleoon.trial.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserRequestDto {

	@Schema(description = "User id", example = "1")
	private Long id;

	@Schema(description = "User name", example = "Tom")
	private String name;

	@Schema(description = "User email", example = "tom@gmail.com")
	private String email;

	@Schema(description = "User password", example = "qwerty123456")
	private String password;

}
