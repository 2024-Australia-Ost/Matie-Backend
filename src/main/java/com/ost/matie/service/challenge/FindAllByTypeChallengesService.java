package com.ost.matie.service.challenge;

import com.ost.matie.dto.challenge.ChallengeResponse;
import com.ost.matie.repository.challenge.ChallengeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FindAllByTypeChallengesService {
    private final ChallengeRepository challengeRepository;

    @Transactional
    public List<ChallengeResponse> execute(Integer type) {
        return challengeRepository.findAllByType(type)
                .stream()
                .map(ChallengeResponse::new)
                .toList();
    }
}
