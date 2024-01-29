package com.ost.matie.repository.clear;

import com.ost.matie.domain.clear.Clear;

import java.time.LocalDate;
import java.util.List;

public interface ClearRepositoryCustom {
    List<Clear> findByUserId(Long userId);

    Clear findByUserIdAndDate(Long userId, LocalDate date);
}
