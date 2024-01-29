package com.ost.matie.service.community;

import com.ost.matie.domain.community.Community;
import com.ost.matie.dto.community.AddCommunityRequest;
import com.ost.matie.dto.community.UpdateCommunityRequest;
import com.ost.matie.exception.NotFoundException;
import com.ost.matie.repository.community.CommunityRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommunityService {
    private final CommunityRepository communityRepository;

    public Community save(AddCommunityRequest request) {
        return communityRepository.save(request.toEntity());
    }

    public List<Community> findByTypeOrderByCreatedDateDesc(String type) {
        if(!(type.equals("Q&A") || type.equals("Debate"))) throw new NotFoundException("type은 Q&A 또는 Debate만 가능합니다.");
        return communityRepository.findByTypeOrderByCreatedDateDesc(type);
    }

    public Community findById(Long id) {
        return communityRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("커뮤니티 정보를 찾을 수 없습니다. (id : " + id + ")"));
    }

    public void delete(Long id) {
        if(!communityRepository.existsById(id)) throw new NotFoundException("커뮤니티 정보를 찾을 수 없습니다. (id : " + id + ")");
        communityRepository.deleteById(id);
    }

    @Transactional
    public Community update(Long id, UpdateCommunityRequest request) {
        Community community = communityRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("커뮤니티 정보를 찾을 수 없습니다. (id : " + id + ")"));

        if(request.getAgree() == null) request.setAgree(community.getAgree());
        if(request.getDisagree() == null) request.setDisagree(community.getDisagree());

        community.update(
                request.getTitle(),
                request.getTitle(),
                request.getAgree(),
                request.getDisagree()
        );

        return community;
    }
}
