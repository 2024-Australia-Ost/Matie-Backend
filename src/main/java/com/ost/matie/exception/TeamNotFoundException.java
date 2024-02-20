package com.ost.matie.exception;

import com.ost.matie.exception.error.BusinessException;
import com.ost.matie.exception.error.ErrorCode;

public class TeamNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new TeamNotFoundException();
    private TeamNotFoundException() { super(ErrorCode.TEAM_NOT_FOUND); }
}
