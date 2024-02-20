package com.ost.matie.exception;

import com.ost.matie.exception.error.BusinessException;
import com.ost.matie.exception.error.ErrorCode;

public class EmailDuplicateException extends BusinessException {
    public static final BusinessException EXCEPTION = new EmailDuplicateException();
    private EmailDuplicateException() { super(ErrorCode.EMAIL_DUPLICATE); }
}
