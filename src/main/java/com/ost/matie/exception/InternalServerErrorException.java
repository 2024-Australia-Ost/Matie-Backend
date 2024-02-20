package com.ost.matie.exception;

import com.ost.matie.exception.error.BusinessException;
import com.ost.matie.exception.error.ErrorCode;

public class InternalServerErrorException extends BusinessException {
    public static final BusinessException EXCEPTION = new InternalServerErrorException();
    private InternalServerErrorException() { super(ErrorCode.INTERNAL_SERVER_ERROR); }
}
