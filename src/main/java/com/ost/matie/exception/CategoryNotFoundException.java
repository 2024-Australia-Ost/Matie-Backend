package com.ost.matie.exception;

import com.ost.matie.exception.error.BusinessException;
import com.ost.matie.exception.error.ErrorCode;

public class CategoryNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new CategoryNotFoundException();
    private CategoryNotFoundException() { super(ErrorCode.CATEGORY_NOT_FOUND); }
}
