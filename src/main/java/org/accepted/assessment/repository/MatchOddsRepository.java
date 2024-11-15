package org.accepted.assessment.repository;


import org.accepted.assessment.model.MatchOdds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchOddsRepository extends JpaRepository<MatchOdds, Long> {

    MatchOdds getMatchOddsById(Long id);
    List<MatchOdds> getMatchOddsByMatch_Id(Long matchId);
}
