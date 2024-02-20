package com.ost.matie.exception;

import com.ost.matie.exception.error.BusinessException;
import com.ost.matie.exception.error.ErrorCode;

public class UserIncorrectException extends BusinessException {
    public static final BusinessException EXCEPTION = new UserIncorrectException();
    private UserIncorrectException() { super(ErrorCode.USER_INCORRECT); }
}
