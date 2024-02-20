package com.ost.matie.service.challenge;

import com.ost.matie.domain.challenge.Challenge;
import com.ost.matie.exception.ChallengeNotFoundException;
import com.ost.matie.exception.TypeNotFoundException;
import com.ost.matie.repository.challenge.ChallengeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ChallengeService {
    private final ChallengeRepository challengeRepository;

    public List<Challenge> findAll() { return challengeRepository.findAll(); }

    public List<Challenge> findAllByChallenge(Integer type) {
        if(!(type == 1 || type == 2 || type == 3 || type == 4)) throw TypeNotFoundException.EXCEPTION;
        return challengeRepository.findAllByType(type);
    }

    public Challenge findById(Long id) {
        return challengeRepository.findById(id)
                .orElseThrow(() -> ChallengeNotFoundException.EXCEPTION);
    }
}
