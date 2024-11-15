package org.accepted.assessment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MatchOddsDto(
        @JsonProperty("odd_id")
        Long oddId,
        @JsonProperty("match_id")
        Long matchId,
        @JsonProperty("specifier")
        String specifier,
        @JsonProperty("odd")
        Float odd) {
}
