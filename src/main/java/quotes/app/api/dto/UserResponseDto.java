package quotes.app.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserResponseDto {

	@Schema(description = "User id")
	private Long id;

	@Schema(description = "User name")
	private String name;

	@Schema(description = "User email")
	private String email;

	@Schema(description = "Date of user creation / update")
	private LocalDateTime dateOfCreation;

}
