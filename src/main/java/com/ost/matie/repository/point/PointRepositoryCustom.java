package com.ost.matie.repository.point;

import com.ost.matie.domain.point.Point;

public interface PointRepositoryCustom {
    Point findFirstByUserIdOrderByCreatedDateDesc(Long userId);
}
