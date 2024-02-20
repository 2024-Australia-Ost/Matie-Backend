package com.ost.matie.service.category;

import com.ost.matie.domain.category.Category;
import com.ost.matie.exception.CategoryNotFoundException;
import com.ost.matie.repository.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category findById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> CategoryNotFoundException.EXCEPTION);
    }
}
