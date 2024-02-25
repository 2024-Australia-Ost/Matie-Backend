package com.ost.matie.repository.comment.upvote;

import com.ost.matie.domain.comment.Upvote;

import java.util.List;

public interface UpvoteRepositoryCustom {
    Long countAllByCommentId(Long commentId);

    List<Upvote> findAllByUserId(Long userId);
    Upvote findByUserIdAndCommentId(Long userId, Long commentId);

    Long deleteByUserIdAndCommentId(Long userId, Long commentId);
}
