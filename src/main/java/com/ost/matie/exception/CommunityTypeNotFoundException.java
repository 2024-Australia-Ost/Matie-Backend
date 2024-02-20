package com.ost.matie.exception;

import com.ost.matie.exception.error.BusinessException;
import com.ost.matie.exception.error.ErrorCode;

public class CommunityTypeNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new CommunityTypeNotFoundException();
    private CommunityTypeNotFoundException() { super(ErrorCode.COMMUNITY_TYPE_NOT_FOUND); }
}
