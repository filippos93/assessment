package org.accepted.assessment.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.lang.Nullable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Dto Object both for requests and responses")
public record MatchOddDto(
        @JsonProperty("odd_id")
        @Schema(nullable = true, description = "Not required on requests, used only to populate the responses")
        Long oddId,
        @JsonProperty("match_id")
        @Schema(nullable = true, description = "Not required on requests, Used only in some responses")
        Long matchId,
        @JsonProperty("specifier")
        @Schema(description = "Populated both on requests & responses")
        String specifier,
        @JsonProperty("odd")
        @Schema(description = "Populated both on requests & responses")
        Double odd) {
}
