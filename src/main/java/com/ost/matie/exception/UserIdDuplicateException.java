package com.ost.matie.exception;

import com.ost.matie.exception.error.BusinessException;
import com.ost.matie.exception.error.ErrorCode;

public class UserIdDuplicateException extends BusinessException {
    public static final BusinessException EXCEPTION = new UserIdDuplicateException();
    private UserIdDuplicateException() { super(ErrorCode.USERID_DUPLICATE); }
}
