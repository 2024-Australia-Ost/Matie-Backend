package com.ost.matie.repository;

import com.ost.matie.domain.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}