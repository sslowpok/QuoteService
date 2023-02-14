package cameleoon.trial.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatusResponseDto {

	@Schema(description = "Result code success/error", example = "success")
	private String statusCode;

	@Schema(description = "Result description", example = "Operation result is success")
	private String statusDesc;

}
