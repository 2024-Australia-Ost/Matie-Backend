package com.ost.matie.service.challenge;

import com.ost.matie.domain.challenge.Challenge;
import com.ost.matie.exception.NotFoundException;
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
        if(!(type == 1 || type == 2 || type == 3 || type == 4)) throw new NotFoundException("type은 1, 2, 3, 4 중 선택해주세요.");
        return challengeRepository.findAllByType(type);
    }

    public Challenge findById(Long id) {
        return challengeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("챌린지의 정보를 찾을 수 없습니다. (id : " + id + ")"));
    }
}
