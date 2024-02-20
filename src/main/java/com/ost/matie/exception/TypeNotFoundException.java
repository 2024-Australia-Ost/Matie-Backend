package com.ost.matie.exception;

import com.ost.matie.exception.error.BusinessException;
import com.ost.matie.exception.error.ErrorCode;

public class TypeNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new TypeNotFoundException();
    private TypeNotFoundException() { super(ErrorCode.TYPE_NOT_FOUND); }
}
