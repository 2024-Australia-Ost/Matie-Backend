package com.ost.matie.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ost.matie.domain.user.Users;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponse {
    private final Long id;
    private final String name;
    private final String userId;
    private final String email;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private final LocalDateTime createdDate;

    public UserResponse(Users users) {
        this.id = users.getId();
        this.name = users.getName();
        this.userId = users.getUserId();
        this.email = users.getEmail();
        this.createdDate = users.getCreatedDate();
    }
}
