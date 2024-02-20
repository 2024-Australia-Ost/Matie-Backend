package com.ost.matie.exception;

import com.ost.matie.exception.error.BusinessException;
import com.ost.matie.exception.error.ErrorCode;

public class ProductNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new ProductNotFoundException();
    private ProductNotFoundException() { super(ErrorCode.PRODUCT_NOT_FOUND); }
}
