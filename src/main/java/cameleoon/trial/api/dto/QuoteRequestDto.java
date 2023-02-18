package cameleoon.trial.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuoteRequestDto {

	@Schema(description = "Quote id", example = "1")
	private Long id;

	@Schema(description = "Sample quote content", example = "I want to believe")
	private	String content;

	@Schema(description = "Id of the author", example = "1")
	private Long userId;

}
