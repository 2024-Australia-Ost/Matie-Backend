package com.ost.matie.dto.comment;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ost.matie.domain.comment.Comment;
import com.ost.matie.domain.community.Community;
import com.ost.matie.domain.user.Users;
import com.ost.matie.dto.community.CommunityResponse;
import com.ost.matie.dto.user.UserResponse;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class CommentResponse {
    private final Long id;
    private final String description;
    private final Long upvotes;
    private final List<Long> upvoteUserList;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;
    private final UserResponse user;
    private final Community community;

    public CommentResponse(Comment comment) {
        this.id = comment.getId();
        this.description = comment.getDescription();
        this.upvotes = comment.getUpvotes();
        this.upvoteUserList = comment.getUpvoteUserList();
        this.createdDate = comment.getCreatedDate();
        this.modifiedDate = comment.getModifiedDate();
        this.user = new UserResponse(comment.getUser());
        this.community = comment.getCommunity();
    }
}
