package com.ost.matie.repository.comment.upvote;

import com.ost.matie.domain.comment.Upvote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpvoteRepository extends JpaRepository<Upvote, Long>, UpvoteRepositoryCustom {
    boolean existsByUserIdAndCommentId(Long userId, Long commentId);
}
