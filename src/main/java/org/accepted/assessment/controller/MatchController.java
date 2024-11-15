package org.accepted.assessment.controller;

import org.accepted.assessment.dto.MatchDto;
import org.accepted.assessment.dto.MatchOddsDto;
import org.accepted.assessment.model.Match;
import org.accepted.assessment.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchController {

    private MatchRepository repository;

    @Autowired
    public MatchController(MatchRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/match/{id}")
    public MatchDto getMatchAndOdds(@PathVariable Long id){
        Match match = repository.getMatchById(id);
        return new MatchDto(
                match.getDescription(),
                match.getMatchDate(),
                match.getMatchTime(),
                match.getTeamA(),
                match.getTeamB(),
                match.getSport(),
                match.getOdds().stream()
                        .map(o -> new MatchOddsDto(o.getId(), o.getMatch().getId(), o.getSpecifier(), o.getOdds()))
                        .toList()
        );

    }
}
