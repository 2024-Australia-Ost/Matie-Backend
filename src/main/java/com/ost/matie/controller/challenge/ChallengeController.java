package com.ost.matie.controller.challenge;

import com.ost.matie.dto.challenge.ChallengeResponse;
import com.ost.matie.service.challenge.FindAllByTypeChallengesService;
import com.ost.matie.service.challenge.FindAllChallengesService;
import com.ost.matie.service.challenge.FindChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/challenge")
public class ChallengeController {
    private final FindAllChallengesService findAllChallengesService;
    private final FindAllByTypeChallengesService findAllByTypeChallengesService;
    private final FindChallengeService findChallengeService;

    @GetMapping
    public List<ChallengeResponse> findAllChallenges() {
        return findAllChallengesService.execute();
    }

    @GetMapping("/type/{type}")
    public List<ChallengeResponse> findAllByTypeChallenges(@PathVariable Integer type) {
        return findAllByTypeChallengesService.execute(type);
    }

    @GetMapping("/{id}")
    public ChallengeResponse findChallenge(@PathVariable Long id) {
        return findChallengeService.execute(id);
    }
}
