package com.ost.matie.service.clear;

import com.ost.matie.domain.clear.Clear;
import com.ost.matie.dto.clear.AddClearRequest;
import com.ost.matie.dto.clear.UpdateClearRequest;
import com.ost.matie.exception.DuplicateException;
import com.ost.matie.exception.NotFoundException;
import com.ost.matie.repository.challenge.ChallengeRepository;
import com.ost.matie.repository.ClearRepository;
import com.ost.matie.repository.TeamRepository;
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
        if(clearRepository.existsByUserIdAndDate(request.getUser().getId(), LocalDate.now())) throw new DuplicateException("이미 해당 유저의 클리어 여부가 존재합니다. update를 해주세요.");
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
            if(!challengeRepository.existsById(challengeId)) throw new NotFoundException("데일리 챌린지 정보를 찾을 수 없습니다. (id : " + challengeId + ")");

        for(Long teamId : teams)
            if(!teamRepository.existsById(teamId)) throw new NotFoundException("그룹 챌린지 정보를 찾을 수 없습니다.");
    }
}
