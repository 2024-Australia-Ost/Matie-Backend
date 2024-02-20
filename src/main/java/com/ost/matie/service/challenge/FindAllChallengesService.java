package com.ost.matie.service.challenge;

import com.ost.matie.dto.challenge.ChallengeResponse;
import com.ost.matie.repository.challenge.ChallengeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FindAllChallengesService {
    private final ChallengeRepository challengeRepository;

    @Transactional
    public List<ChallengeResponse> execute() {
        return challengeRepository.findAll()
                .stream()
                .map(ChallengeResponse::new)
                .toList();
    }
}
