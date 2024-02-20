package com.ost.matie.exception;

import com.ost.matie.exception.error.BusinessException;
import com.ost.matie.exception.error.ErrorCode;

public class CommentNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new CommentNotFoundException();
    private CommentNotFoundException() { super(ErrorCode.COMMENT_NOT_FOUND); }
}
