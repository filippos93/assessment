package org.accepted.assessment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.accepted.assessment.model.enums.Sport;

import java.util.Date;

public record MatchRequestDto(
        @JsonProperty("description")
        String description,
        @JsonProperty("match_datetime")
        Date matchDatetime,
        @JsonProperty("team_a")
        String teamA,
        @JsonProperty("team_b")
        String teamB,
        @JsonProperty("sport")
        Sport sport) {
}
