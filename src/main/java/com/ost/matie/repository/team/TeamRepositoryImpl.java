package com.ost.matie.repository.team;

import com.ost.matie.domain.team.Team;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import static com.ost.matie.domain.team.QTeam.team;

@Repository
@RequiredArgsConstructor
public class TeamRepositoryImpl implements TeamRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Team> findAllByLocalDate() {
        return queryFactory
                .selectFrom(team)
                .where(team.startDate.loe(LocalDateTime.now()).and(team.finishDate.goe(LocalDateTime.now())))
                .fetch();
    }
}
