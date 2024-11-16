package org.accepted.assessment.repository;

import org.accepted.assessment.model.Match;
import org.accepted.assessment.model.enums.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    Match getMatchById(Long id);

    @Transactional
    @Modifying
    @Query("""
            update Match m set m.description = ?1, m.matchDate = ?2, m.matchTime = ?3, m.teamA = ?4, m.teamB = ?5, m.sport = ?6
            where m.id = ?7""")
    int updateDescriptionAndMatchDateAndMatchTimeAndTeamAAndTeamBAndSportById(String description, Date matchDate, Time matchTime, String teamA, String teamB, Sport sport, Long id);

}
