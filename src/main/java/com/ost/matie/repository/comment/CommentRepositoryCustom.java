package com.ost.matie.repository.comment;

import com.ost.matie.domain.comment.Comment;

import java.util.List;

public interface CommentRepositoryCustom {
    List<Comment> findAllByCommunityId(Long communityId);
}
