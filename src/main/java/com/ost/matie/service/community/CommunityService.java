package com.ost.matie.service.community;

import com.ost.matie.domain.community.Community;
import com.ost.matie.dto.community.AddCommunityRequest;
import com.ost.matie.dto.community.UpdateCommunityRequest;
import com.ost.matie.exception.CommunityNotFoundException;
import com.ost.matie.exception.CommunityTypeNotFoundException;
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
        if(!(type.equals("Q&A") || type.equals("Debate"))) throw CommunityTypeNotFoundException.EXCEPTION;
        return communityRepository.findByTypeOrderByCreatedDateDesc(type);
    }

    public Community findById(Long id) {
        return communityRepository.findById(id)
                .orElseThrow(() -> CommunityNotFoundException.EXCEPTION);
    }

    public void delete(Long id) {
        if(!communityRepository.existsById(id)) throw CommunityNotFoundException.EXCEPTION;
        communityRepository.deleteById(id);
    }

    @Transactional
    public Community update(Long id, UpdateCommunityRequest request) {
        Community community = communityRepository.findById(id)
                .orElseThrow(() -> CommunityNotFoundException.EXCEPTION);

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
