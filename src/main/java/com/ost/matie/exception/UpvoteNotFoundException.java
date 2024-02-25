package com.ost.matie.exception;

import com.ost.matie.exception.error.BusinessException;
import com.ost.matie.exception.error.ErrorCode;

public class UpvoteNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new UpvoteNotFoundException();
    private UpvoteNotFoundException() { super(ErrorCode.UPVOTE_NOT_FOUND); }
}
