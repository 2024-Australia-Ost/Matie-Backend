package com.ost.matie.repository.comment.comment;

import com.ost.matie.domain.comment.Comment;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.ost.matie.domain.comment.QComment.comment;

@Repository
@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Comment> findAllByCommunityId(Long communityId) {
        return queryFactory
                .selectFrom(comment)
                .where(comment.community.id.eq(communityId))
                .fetch();
    }
}
