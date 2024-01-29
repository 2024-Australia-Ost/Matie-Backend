package com.ost.matie.repository.community;

import com.ost.matie.domain.community.Community;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommunityRepository extends JpaRepository<Community, Long>, CommunityRepositoryCustom {
}
