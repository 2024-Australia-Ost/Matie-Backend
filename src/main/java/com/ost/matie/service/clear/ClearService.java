package com.ost.matie.service.clear;

import com.ost.matie.domain.clear.Clear;
import com.ost.matie.dto.clear.AddClearRequest;
import com.ost.matie.dto.clear.UpdateClearRequest;
import com.ost.matie.exception.ChallengeNotFoundException;
import com.ost.matie.exception.TeamNotFoundException;
import com.ost.matie.exception.UserClearDuplicateException;
import com.ost.matie.repository.challenge.ChallengeRepository;
import com.ost.matie.repository.clear.ClearRepository;
import com.ost.matie.repository.team.TeamRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ClearService {
    private final ClearRepository clearRepository;
    private final ChallengeRepository challengeRepository;
    private final TeamRepository teamRepository;

    public Clear save(AddClearRequest request) {
        if(clearRepository.existsByUserIdAndDate(request.getUser().getId(), LocalDate.now())) throw UserClearDuplicateException.EXCEPTION;
        checkChallengeAndTeam(request.getChallenge(), request.getTeam());
        return clearRepository.save(request.toEntity());
    }

    public List<Clear> findAllSevenDays(Long userId) {
        List<Clear> clears = clearRepository.findByUserId(userId)
                .stream()
                .filter(clear -> clear.getDate().isAfter(LocalDate.now().minusDays(7)))
                .collect(Collectors.toList());

        return clears;
    }

    @Transactional
    public Clear update(Long userId, UpdateClearRequest request) {
        checkChallengeAndTeam(request.getChallenge(), request.getTeam());
        Clear clear = clearRepository.findByUserIdAndDate(userId, LocalDate.now());
        clear.update(request.getChallenge(), request.getTeam());
        return clear;
    }

    private void checkChallengeAndTeam(List<Long> challenges, List<Long> teams) {
        for(Long challengeId : challenges)
            if(!challengeRepository.existsById(challengeId)) throw ChallengeNotFoundException.EXCEPTION;

        for(Long teamId : teams)
            if(!teamRepository.existsById(teamId)) throw TeamNotFoundException.EXCEPTION;
    }
}
