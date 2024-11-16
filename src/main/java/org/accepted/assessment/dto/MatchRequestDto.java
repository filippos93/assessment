package org.accepted.assessment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.accepted.assessment.model.enums.Sport;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record MatchRequestDto(
        @JsonProperty("description")
        @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
        String description,
        @JsonProperty("match_datetime")
        @JsonFormat(pattern="dd-MM-yyyy HH:mm")
        @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
        Date matchDatetime,
        @JsonProperty("team_a")
        @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
        String teamA,
        @JsonProperty("team_b")
        @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
        String teamB,
        @JsonProperty("sport")
        @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
        Sport sport,
        @JsonProperty("odds")
        @Schema(description = "Can be null or empty list")
        List<MatchOddDto> odds) {
}
