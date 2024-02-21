package com.ost.matie.domain.clear;

import com.ost.matie.domain.challenge.Challenge;
import com.ost.matie.domain.team.Team;
import com.ost.matie.domain.user.Users;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Clear {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "challenge_id")
    private Challenge challenge;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Builder
    public Clear(LocalDate date, Challenge challenge, Team team, Users user) {
        this.date = date;
        this.challenge = challenge;
        this.team = team;
        this.user = user;
    }
}
