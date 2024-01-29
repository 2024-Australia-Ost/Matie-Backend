package com.ost.matie.repository.team;

import com.ost.matie.domain.team.Team;

import java.time.LocalDateTime;
import java.util.List;

public interface TeamRepositoryCustom {
    List<Team> findAllByLocalDate();
}
