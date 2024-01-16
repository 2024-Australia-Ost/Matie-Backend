package com.ost.matie.service.category;

import com.ost.matie.domain.category.Category;
import com.ost.matie.exception.DataNotFoundException;
import com.ost.matie.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category findById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("카테고리의 정보를 찾을 수 없습니다. (id : " + id + ")"));
    }
}
