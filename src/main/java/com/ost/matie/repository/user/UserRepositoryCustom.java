package com.ost.matie.repository.user;

import com.ost.matie.domain.user.Users;

public interface UserRepositoryCustom {
    Users findByUserIdOrEmail(String userId, String email);
    Users findByEmail(String email);
}
