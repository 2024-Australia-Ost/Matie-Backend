package com.ost.matie.dto.walk;

import com.ost.matie.domain.user.Users;
import com.ost.matie.domain.walk.Walk;
import com.ost.matie.dto.user.UserResponse;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class WalkResponse {
    private final Long id;
    private final Long count;
    private final LocalDate date;
    private final UserResponse user;

    public WalkResponse(Walk walk) {
        this.id = walk.getId();
        this.count = walk.getCount();
        this.date = walk.getDate();
        this.user = new UserResponse(walk.getUser());
    }
}