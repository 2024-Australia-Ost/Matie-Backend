package com.ost.matie.repository.user;

import com.ost.matie.domain.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long>, UserRepositoryCustom {
    boolean existsByUserId(String userId);
    boolean existsByEmail(String email);
}
