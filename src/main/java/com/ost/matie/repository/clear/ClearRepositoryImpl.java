package com.ost.matie.repository.clear;

import com.ost.matie.domain.clear.Clear;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import static com.ost.matie.domain.clear.QClear.clear;

@Repository
@RequiredArgsConstructor
public class ClearRepositoryImpl implements ClearRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Clear> findByUserId(Long userId) {
        return queryFactory
                .selectFrom(clear)
                .where(clear.user.id.eq(userId))
                .fetch();
    }

    @Override
    public Clear findByUserIdAndDate(Long userId, LocalDate date) {
        return queryFactory
                .selectFrom(clear)
                .where(clear.user.id.eq(userId)
                        .and(clear.date.eq(date))
                )
                .fetchOne();
    }
}
