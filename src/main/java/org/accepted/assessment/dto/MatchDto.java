package org.accepted.assessment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.accepted.assessment.model.enums.Sport;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public record MatchDto(
        @JsonProperty("description")
        String description,
        @JsonProperty("match_date")
        @JsonFormat(pattern="dd/MM/yyyy")
        Date matchDate,
        @JsonProperty("match_time")
        @JsonFormat(pattern="HH:mm")
        Time matchTime,
        @JsonProperty("team_a")
        String teamA,
        @JsonProperty("team_b")
        String teamB,
        @JsonProperty("sport")
        Sport sport,
        @JsonProperty("odds")
        List<MatchOddsDto> odds) {
}
