package quotes.app.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatusResponseDto {

    public Integer code;

    public String desc;

}
