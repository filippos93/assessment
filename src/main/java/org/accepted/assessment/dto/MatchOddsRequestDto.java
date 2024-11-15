package org.accepted.assessment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MatchOddsRequestDto(
        @JsonProperty("match_id")
        Long matchId,
        @JsonProperty("specifier")
        String specifier,
        @JsonProperty("odds")
        Float odds) {
}
