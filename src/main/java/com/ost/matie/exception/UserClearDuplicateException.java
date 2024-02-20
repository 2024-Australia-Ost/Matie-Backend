package com.ost.matie.exception;

import com.ost.matie.exception.error.BusinessException;
import com.ost.matie.exception.error.ErrorCode;

public class UserClearDuplicateException extends BusinessException {
    public static final BusinessException EXCEPTION = new UserClearDuplicateException();
    private UserClearDuplicateException() { super(ErrorCode.USER_CLEAR_DUPLICATE); }
}
