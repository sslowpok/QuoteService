package quotes.app.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequestDto {

	@Schema(description = "User name", example = "Tom")
	private String name;

	@Schema(description = "User email", example = "tom@gmail.com")
	private String email;

	@Schema(description = "User password", example = "qwerty123456")
	private String password;

}
