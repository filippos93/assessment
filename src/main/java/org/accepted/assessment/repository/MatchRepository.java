package org.accepted.assessment.repository;

import org.accepted.assessment.model.Match;
import org.accepted.assessment.model.enums.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    Match getMatchById(Long id);
    List<Match> getMatchByTeamA(String teamA);
    List<Match> getMatchByTeamB(String teamB);
    List<Match> getMatchBySportAndTeamA(Sport sport, String teamA);
    List<Match> getMatchBySportAndTeamB(Sport sport, String teamB);
    List<Match> getMatchByMatchDateAfter(Date matchDate);
}
