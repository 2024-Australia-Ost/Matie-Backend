package com.ost.matie.dto.clear;

import com.ost.matie.domain.challenge.Challenge;
import com.ost.matie.domain.clear.Clear;
import com.ost.matie.domain.team.Team;
import com.ost.matie.domain.user.Users;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddClearRequest {
    @NotNull(message = "challenge의 id를 적어주세요.")
    private Challenge challenge;

    private Team team;

    @NotNull(message = "user의 id를 적어주세요.")
    private Users user;

    public Clear toEntity() {
        return Clear.builder()
                .date(LocalDate.now())
                .challenge(challenge)
                .team(team)
                .user(user)
                .build();
    }
}
