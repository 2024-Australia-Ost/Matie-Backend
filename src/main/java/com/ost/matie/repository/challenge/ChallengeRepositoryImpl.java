package com.ost.matie.repository.challenge;

import com.ost.matie.domain.challenge.Challenge;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.ost.matie.domain.challenge.QChallenge.challenge;

@Repository
@RequiredArgsConstructor
public class ChallengeRepositoryImpl implements ChallengeRepositoryCustom {
    private final JPAQueryFactory queryFactory;


    @Override
    public List<Challenge> findAllByType(Integer type) {
        return queryFactory
                .selectFrom(challenge)
                .fetch();
    }
}
