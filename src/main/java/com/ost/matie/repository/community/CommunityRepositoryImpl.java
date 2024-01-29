package com.ost.matie.repository.community;

import com.ost.matie.domain.community.Community;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.ost.matie.domain.community.QCommunity.community;

@Repository
@RequiredArgsConstructor
public class CommunityRepositoryImpl implements CommunityRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Community> findByTypeOrderByCreatedDateDesc(String type) {
        return queryFactory
                .selectFrom(community)
                .where(community.type.eq(type))
                .orderBy(community.createdDate.desc())
                .fetch();
    }
}
