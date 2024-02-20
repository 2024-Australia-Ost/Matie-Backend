package com.ost.matie.exception;

import com.ost.matie.exception.error.BusinessException;
import com.ost.matie.exception.error.ErrorCode;

public class CommunityNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new CommunityNotFoundException();
    private CommunityNotFoundException() { super(ErrorCode.COMMUNITY_NOT_FOUND); }
}
