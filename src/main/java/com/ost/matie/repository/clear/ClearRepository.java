package com.ost.matie.repository.clear;

import com.ost.matie.domain.clear.Clear;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface ClearRepository extends JpaRepository<Clear, Long>, ClearRepositoryCustom {
    boolean existsByUserIdAndDate(Long userId, LocalDate date);
}
