package cameleoon.trial.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class QuoteResponseDto {

	@Schema(description = "Quote id", example = "1")
	private Long id;

	@Schema(description = "Quote content", example = "I still want to believe")
	private String content;

	@Schema(description = "Date of creation/update")
	private LocalDateTime timestamp;

	@Schema(description = "Quote author id (user")
	private Long userId;

}
