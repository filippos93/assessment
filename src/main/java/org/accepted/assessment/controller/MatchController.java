package org.accepted.assessment.controller;

import org.accepted.assessment.dto.MatchDto;
import org.accepted.assessment.dto.MatchOddDto;
import org.accepted.assessment.dto.MatchRequestDto;
import org.accepted.assessment.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MatchController {

    private MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/match/all")
    @ResponseStatus(HttpStatus.OK)
    public List<MatchDto> getMatches(boolean odds) {
        return matchService.getAllMatches(odds);
    }

    @GetMapping("/match/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MatchDto getMatch(@PathVariable Long id, @RequestParam boolean odds){
        return matchService.getMatch(id, odds);
    }

    @PostMapping("/match")
    @ResponseStatus(HttpStatus.CREATED)
    public MatchDto createMatch(@RequestBody MatchRequestDto requestDto) {
        return matchService.createMatch(requestDto);
    }

    @PatchMapping("/match/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MatchDto updateMatch(@PathVariable Long id, @RequestBody MatchRequestDto requestDto) {
        return matchService.updateMatch(id, requestDto);
    }

    @PutMapping("/match/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void replaceMatch(@PathVariable Long id, @RequestBody MatchRequestDto requestDto) {
        matchService.updateAllMatch(id, requestDto);
    }

    @DeleteMapping("/match/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMatch(@PathVariable Long id) {
        matchService.deleteMatch(id);
    }

    /*
        Match Odds REST APIs
     */

    @GetMapping("/match/odd/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MatchOddDto getOddMatch(@PathVariable Long id) {
        return matchService.getOdd(id);
    }

    @GetMapping("/match/{id}/odds")
    @ResponseStatus(HttpStatus.OK)
    public List<MatchOddDto> getMatchOdds(@PathVariable Long id) {
        return matchService.getMatchOdds(id);
    }

    @PutMapping("/match/odd/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateMatchOdd(@PathVariable Long id, @RequestBody MatchOddDto requestDto) {
        matchService.updateMatchOdd(id, requestDto);
    }

    @PostMapping("/match/{id}/odd")
    @ResponseStatus(HttpStatus.CREATED)
    public MatchOddDto createMatchOdd(@PathVariable Long id, @RequestBody MatchOddDto requestDto) {
        return matchService.createMatchOdd(id, requestDto);
    }

    @DeleteMapping("/match/odd/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMatchOdd(@PathVariable Long id) {
        matchService.deleteMatchOdd(id);
    }

}
