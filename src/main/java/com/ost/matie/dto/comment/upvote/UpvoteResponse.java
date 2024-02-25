package com.ost.matie.dto.comment.upvote;

import com.ost.matie.domain.comment.Comment;
import com.ost.matie.domain.comment.Upvote;
import com.ost.matie.dto.user.UserResponse;
import lombok.Getter;

@Getter
public class UpvoteResponse {
    private final Long id;
    private final UserResponse user;
    private final Comment comment;

    public UpvoteResponse(Upvote upvote) {
        this.id = upvote.getId();
        this.user = new UserResponse(upvote.getUser());
        this.comment = upvote.getComment();
    }
}
