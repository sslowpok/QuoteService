package cameleoon.trial.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class QuoteResponseDto {

	@Schema(description = "Quote id")
	private Long id;

	@Schema(description = "Quote content")
	private String content;

	@Schema(description = "Date of creation/update")
	private LocalDateTime timestamp;

	@Schema(description = "Quote author id (user")
	private Long userId;

	@Schema(description = "Quote score")
	private Integer score;

}
