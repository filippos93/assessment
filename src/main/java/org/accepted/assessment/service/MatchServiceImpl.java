package org.accepted.assessment.service;

import org.accepted.assessment.dto.MatchOddDto;
import org.accepted.assessment.exception.ResourceNotFoundException;
import org.accepted.assessment.dto.MatchDto;
import org.accepted.assessment.dto.MatchRequestDto;
import org.accepted.assessment.model.Match;
import org.accepted.assessment.model.MatchOdds;
import org.accepted.assessment.repository.MatchOddsRepository;
import org.accepted.assessment.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    private MatchRepository matchRepository;
    private MatchOddsRepository matchOddsRepository;


    @Override
    public List<MatchDto> getAllMatches(boolean odds) {
        return matchRepository.findAll().stream().map(m -> m.toMatchDto(odds)).toList();
    }

    @Override
    public MatchDto getMatch(Long id, boolean odds) {
        try {
            return matchRepository.getMatchById(id).toMatchDto(odds);
        } catch (NullPointerException e){
            throw new ResourceNotFoundException("Match with id " + id + " not found");
        }
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public MatchDto createMatch(MatchRequestDto req) {
        Match match = new Match();
        match.setDescription(req.description());
        match.setMatchDate(new java.sql.Date(req.matchDatetime().getTime()));
        match.setMatchTime(new java.sql.Time(req.matchDatetime().getTime()));
        match.setSport(req.sport());
        match.setTeamA(req.teamA());
        match.setTeamB(req.teamB());
        Match persistedMatch = matchRepository.saveAndFlush(match);
        if (req.odds() != null && !req.odds().isEmpty()) {
            List<MatchOdds> matchOdds = req.odds().stream().map(o -> {
                MatchOdds odds = new MatchOdds();
                odds.setOdds(o.odd());
                odds.setMatch(persistedMatch);
                odds.setSpecifier(o.specifier());
                return odds;
            }).toList();
            List<MatchOdds> odds = matchOddsRepository.saveAllAndFlush(matchOdds);
            persistedMatch.setOdds(odds);
        }
        return persistedMatch.toMatchDto(true);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public MatchDto updateMatch(Long matchId, MatchRequestDto req) {
        Match match = matchRepository.getMatchById(matchId);
        if (match == null){
            throw new ResourceNotFoundException("Match with id " + matchId + " not found");
        }
        if (req.matchDatetime() != null) {
            match.setMatchDate(new java.sql.Date(req.matchDatetime().getTime()));
            match.setMatchTime(new java.sql.Time(req.matchDatetime().getTime()));
        }
        if (req.description() != null) {
            match.setDescription(req.description());
        }
        if (req.teamA() != null) {
            match.setTeamA(req.teamA());
        }
        if (req.teamB() != null) {
            match.setTeamB(req.teamB());
        }
        if (req.sport() != null) {
            match.setSport(req.sport());
        }

        return matchRepository.saveAndFlush(match).toMatchDto(true);
    }

    @Override
    public void updateAllMatch(Long matchId, MatchRequestDto req) {
        matchRepository.updateDescriptionAndMatchDateAndMatchTimeAndTeamAAndTeamBAndSportById(
                req.description(),
                new java.sql.Date(req.matchDatetime().getTime()),
                new java.sql.Time(req.matchDatetime().getTime()),
                req.teamA(),
                req.teamB(),
                req.sport(),
                matchId);
    }

    @Override
    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }

    /*
       Match Odds Services
     */

    @Override
    public MatchOddDto getOdd(Long id) {
        try {
            return matchOddsRepository.getMatchOddsById(id).toMatchOddsDto(true);
        } catch (NullPointerException e){
            throw new ResourceNotFoundException("Match Odd with id " + id + " not found");
        }
    }

    @Override
    public List<MatchOddDto> getMatchOdds(Long matchId) {
        return matchOddsRepository.getMatchOddsByMatch_Id(matchId).stream().map(MatchOdds::toMatchOddsDto).toList();
    }

    @Override
    public void updateMatchOdd(Long id, MatchOddDto req) {
        matchOddsRepository.updateSpecifierAndOddsById(req.specifier(), req.odd(), id);
    }

    @Override
    public MatchOddDto createMatchOdd(Long matchId, MatchOddDto req) {
        Match match = matchRepository.getMatchById(matchId);
        if (match == null){
            throw new ResourceNotFoundException("Match with id " + matchId + " not found");
        }
        MatchOdds matchOdd = new MatchOdds();
        matchOdd.setMatch(match);
        matchOdd.setOdds(req.odd());
        matchOdd.setSpecifier(req.specifier());
        return matchOddsRepository.save(matchOdd).toMatchOddsDto(true);
    }

    @Override
    public void deleteMatchOdd(Long oddId) {
        matchOddsRepository.deleteById(oddId);
    }

    @Autowired
    public void setMatchRepository(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Autowired
    public void setMatchOddsRepository(MatchOddsRepository matchOddsRepository) {
        this.matchOddsRepository = matchOddsRepository;
    }
}
