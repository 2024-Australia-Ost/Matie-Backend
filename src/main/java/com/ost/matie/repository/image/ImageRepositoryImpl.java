package com.ost.matie.repository.image;

import com.ost.matie.domain.image.Image;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.ost.matie.domain.image.QImage.image;

@Repository
@RequiredArgsConstructor
public class ImageRepositoryImpl implements ImageRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Image> findAllByType(Integer type) {
        return queryFactory
                .selectFrom(image)
                .where(image.type.eq(type))
                .fetch();
    }
}
