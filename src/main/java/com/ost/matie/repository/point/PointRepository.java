package com.ost.matie.repository.point;

import com.ost.matie.domain.point.Point;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointRepository extends JpaRepository<Point, Long>, PointRepositoryCustom {
}
