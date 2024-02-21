package com.ost.matie.dto.clear;

import com.ost.matie.domain.challenge.Challenge;
import com.ost.matie.domain.clear.Clear;
import com.ost.matie.domain.team.Team;
import com.ost.matie.dto.user.UserResponse;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ClearResponse {
    private final Long id;
    private final LocalDate date;
    private final Challenge challenge;
    private final Team team;
    private final UserResponse user;

    public ClearResponse(Clear clear) {
        this.id = clear.getId();
        this.date = clear.getDate();
        this.challenge = clear.getChallenge();
        this.team = clear.getTeam();
        this.user = new UserResponse(clear.getUser());
    }
}
