package org.accepted.assessment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.accepted.assessment.model.enums.Sport;
import org.springframework.lang.Nullable;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record MatchDto(
        @JsonProperty("match_id")
        Long matchId,
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
        List<MatchOddDto> odds) {

        public MatchDto(Long matchId, String description, Date matchDate, Time matchTime, String teamA, String teamB, Sport sport) {
                this(matchId, description, matchDate, matchTime, teamA, teamB, sport, new ArrayList<>());
        }
}
