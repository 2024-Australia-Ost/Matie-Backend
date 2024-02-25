package com.ost.matie.repository.comment.upvote;

import com.ost.matie.domain.comment.Upvote;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.ost.matie.domain.comment.QUpvote.upvote;

@Repository
@RequiredArgsConstructor
public class UpvoteRepositoryImpl implements UpvoteRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public Long countAllByCommentId(Long commentId) {
        return queryFactory
                .select(upvote.count())
                .from(upvote)
                .where(upvote.comment.id.eq(commentId))
                .fetchOne();
    }

    @Override
    public List<Upvote> findAllByUserId(Long userId) {
        return queryFactory
                .selectFrom(upvote)
                .where(upvote.user.id.eq(userId))
                .fetch();
    }

    @Override
    public Upvote findByUserIdAndCommentId(Long userId, Long commentId) {
        return queryFactory
                .selectFrom(upvote)
                .where(upvote.user.id.eq(userId).and(upvote.comment.id.eq(commentId)))
                .fetchOne();
    }

    @Override
    public Long deleteByUserIdAndCommentId(Long userId, Long commentId) {
        return queryFactory
                .delete(upvote)
                .where(upvote.user.id.eq(userId).and(upvote.comment.id.eq(commentId)))
                .execute();
    }
}
