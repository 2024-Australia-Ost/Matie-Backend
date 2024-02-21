package com.ost.matie.service.clear;

import com.ost.matie.dto.clear.AddClearRequest;
import com.ost.matie.exception.ChallengeNotFoundException;
import com.ost.matie.exception.UserClearDuplicateException;
import com.ost.matie.exception.UserNotFoundException;
import com.ost.matie.repository.challenge.ChallengeRepository;
import com.ost.matie.repository.clear.ClearRepository;
import com.ost.matie.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class AddClearService {
    private final ClearRepository clearRepository;
    private final UserRepository userRepository;
    private final ChallengeRepository challengeRepository;

    @Transactional
    public void execute(AddClearRequest request) {
        if(clearRepository.existsByUserIdAndTeamIdAndChallengeIdAndDate(
                request.getUser().getId(),
                request.getTeam() == null ? null : request.getTeam().getId(),
                request.getChallenge().getId(),
                LocalDate.now()
        )) throw UserClearDuplicateException.EXCEPTION;
        if(!userRepository.existsById(request.getUser().getId())) throw UserNotFoundException.EXCEPTION;
        if(!challengeRepository.existsById(request.getChallenge().getId())) throw ChallengeNotFoundException.EXCEPTION;

        clearRepository.save(request.toEntity());
    }
}
