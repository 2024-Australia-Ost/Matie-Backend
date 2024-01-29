package com.ost.matie.repository.point;

import com.ost.matie.domain.point.Point;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.ost.matie.domain.point.QPoint.point;

@Repository
@RequiredArgsConstructor
public class PointRepositoryImpl implements PointRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public Point findFirstByUserIdOrderByCreatedDateDesc(Long userId) {
        return queryFactory
                .selectFrom(point)
                .where(point.user.id.eq(userId))
                .orderBy(point.createdDate.desc())
                .fetchFirst();
    }
}
