package com.ost.matie.repository.image;

import com.ost.matie.domain.image.Image;

import java.util.List;

public interface ImageRepositoryCustom {
    List<Image> findAllByType(Integer type);
}
