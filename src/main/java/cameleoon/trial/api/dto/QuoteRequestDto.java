package cameleoon.trial.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuoteRequestDto {

	@Schema(description = "Quote id")
	private Long id;

	@Schema(name = "Quote content", example = "I want to believe")
	private	String content;

	@Schema(description = "Id of the author")
	private Long userId;


}
