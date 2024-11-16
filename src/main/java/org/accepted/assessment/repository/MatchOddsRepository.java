package org.accepted.assessment.repository;

import org.accepted.assessment.model.MatchOdds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MatchOddsRepository extends JpaRepository<MatchOdds, Long> {

    MatchOdds getMatchOddsById(Long id);
    List<MatchOdds> getMatchOddsByMatch_Id(Long matchId);

    @Transactional
    @Modifying
    @Query("update MatchOdds m set m.specifier = ?1, m.odds = ?2 where m.id = ?3")
    int updateSpecifierAndOddsById(String specifier, Double odds, Long id);
}
