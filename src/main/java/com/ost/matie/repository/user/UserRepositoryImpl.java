package com.ost.matie.repository.user;

import com.ost.matie.domain.user.Users;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.ost.matie.domain.user.QUsers.users;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public Users findByUserIdOrEmail(String userId, String email) {
        return queryFactory
                .selectFrom(users)
                .where(users.userId.eq(userId).or(users.email.eq(email)))
                .fetchOne();
    }

    @Override
    public Users findByEmail(String email) {
        return queryFactory
                .selectFrom(users)
                .where(users.email.eq(email))
                .fetchOne();
    }
}
