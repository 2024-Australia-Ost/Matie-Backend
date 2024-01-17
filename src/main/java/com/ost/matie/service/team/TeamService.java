package com.ost.matie.service.team;

import com.ost.matie.domain.team.Team;
import com.ost.matie.dto.team.UpdateTeamRequest;
import com.ost.matie.exception.DataNotFoundException;
import com.ost.matie.exception.UserNotFoundException;
import com.ost.matie.repository.TeamRepository;
import com.ost.matie.repository.UserRepository;
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

    public List<Team> findAll() { return teamRepository.findAll(); }

    public List<Team> findUserListInUserId(Long userId) {
        if(!userRepository.existsById(userId)) throw new UserNotFoundException("사용자를 찾을 수 없습니다. (id : " + userId + ")");

        List<Team> team = teamRepository.findAll()
                .stream()
                .filter(teams -> teams.getUserList().contains(userId))
                .collect(Collectors.toList());

        return team;
    }

    @Transactional
    public Team update(Long id, UpdateTeamRequest request) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("그룹 챌린지 정보를 찾을 수 없습니다. (id : " + id + ")"));

        for(Long userId : request.getUserList())
            if(!userRepository.existsById(userId)) throw new UserNotFoundException("사용자 정보를 찾을 수 없습니다. (id : " + userId + ")");

        team.update(request.getUserList());

        return team;
    }
}
