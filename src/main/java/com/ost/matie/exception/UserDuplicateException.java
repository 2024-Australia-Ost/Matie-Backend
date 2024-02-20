package com.ost.matie.exception;

import com.ost.matie.exception.error.BusinessException;
import com.ost.matie.exception.error.ErrorCode;

public class UserDuplicateException extends BusinessException {
    public static final BusinessException EXCEPTION = new UserDuplicateException();
    private UserDuplicateException() { super(ErrorCode.USER_DUPLICATE); }
}
