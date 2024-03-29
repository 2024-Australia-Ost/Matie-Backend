package com.ost.matie.dto.team;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ost.matie.domain.image.Image;
import com.ost.matie.domain.team.Team;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class TeamResponse {
    private final Long id;
    private final String title;
    private final String description;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private final LocalDateTime startDate;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private final LocalDateTime finishDate;

    private final Long point;

    private final List<Long> userList;

    public TeamResponse(Team team) {
        this.id = team.getId();
        this.title = team.getTitle();
        this.description = team.getDescription();
        this.startDate = team.getStartDate();
        this.finishDate = team.getFinishDate();
        this.point = team.getPoint();
        this.userList = team.getUserList();
    }
}
