package com.ost.matie.service.challenge;

import com.ost.matie.dto.challenge.ChallengeResponse;
import com.ost.matie.exception.ChallengeNotFoundException;
import com.ost.matie.repository.challenge.ChallengeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FindChallengeService {
    private final ChallengeRepository challengeRepository;

    @Transactional
    public ChallengeResponse execute(Long id) {
        return new ChallengeResponse(challengeRepository.findById(id).orElseThrow(() -> ChallengeNotFoundException.EXCEPTION));
    }
}
