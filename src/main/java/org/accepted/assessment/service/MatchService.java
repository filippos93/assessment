package org.accepted.assessment.service;

import org.accepted.assessment.dto.MatchDto;
import org.accepted.assessment.dto.MatchOddDto;
import org.accepted.assessment.dto.MatchRequestDto;

import java.util.List;

public interface MatchService {

    List<MatchDto> getAllMatches(boolean odds);

    MatchDto getMatch(Long id, boolean odds);

    MatchDto createMatch(MatchRequestDto req);

    MatchDto updateMatch(Long matchId, MatchRequestDto req);

    void updateAllMatch(Long matchId, MatchRequestDto req);

    void deleteMatch(Long id);

    MatchOddDto getOdd(Long id);

    List<MatchOddDto> getMatchOdds(Long matchId);

    void updateMatchOdd(Long id, MatchOddDto req);

    MatchOddDto createMatchOdd(Long matchId, MatchOddDto req);

    void deleteMatchOdd(Long matchId);
}
