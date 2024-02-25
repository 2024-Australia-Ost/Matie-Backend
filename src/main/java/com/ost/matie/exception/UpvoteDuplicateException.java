package com.ost.matie.exception;

import com.ost.matie.exception.error.BusinessException;
import com.ost.matie.exception.error.ErrorCode;

public class UpvoteDuplicateException extends BusinessException {
    public static final BusinessException EXCEPTION = new UpvoteDuplicateException();

    private UpvoteDuplicateException() { super(ErrorCode.UPVOTE_DUPLICATE); }
}
