package com.ost.matie.service.team;

import com.ost.matie.domain.team.Team;
import com.ost.matie.dto.team.UpdateTeamRequest;
import com.ost.matie.exception.TeamNotFoundException;
import com.ost.matie.exception.UserNotFoundException;
import com.ost.matie.repository.team.TeamRepository;
import com.ost.matie.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TeamService {
    private final TeamRepository teamRepository;
    private final UserRepository userRepository;

    public List<Team> findAll() {
        return teamRepository.findAllByLocalDate();
    }

    public List<Team> findUserListInUserId(Long userId) {
        List<Team> team = teamRepository.findAll()
                .stream()
                .filter(teams -> teams.getUserList().contains(userId))
                .collect(Collectors.toList());

        return team;
    }

    @Transactional
    public Team update(Long id, UpdateTeamRequest request) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> TeamNotFoundException.EXCEPTION);

        for(Long userId : request.getUserList())
            if(!userRepository.existsById(userId)) throw UserNotFoundException.EXCEPTION;

        team.update(request.getUserList());

        return team;
    }
}
