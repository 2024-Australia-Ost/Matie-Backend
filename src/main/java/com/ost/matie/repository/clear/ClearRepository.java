package com.ost.matie.repository.clear;

import com.ost.matie.domain.clear.Clear;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ClearRepository extends JpaRepository<Clear, Long>, ClearRepositoryCustom {
    boolean existsByUserIdAndDate(Long userId, LocalDate date);
}
