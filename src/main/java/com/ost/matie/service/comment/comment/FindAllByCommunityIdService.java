package com.ost.matie.service.comment.comment;

import com.ost.matie.dto.comment.comment.CommentResponse;
import com.ost.matie.exception.CommunityNotFoundException;
import com.ost.matie.repository.comment.comment.CommentRepository;
import com.ost.matie.repository.community.CommunityRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FindAllByCommunityIdService {
    private final CommentRepository commentRepository;
    private final CommunityRepository communityRepository;

    @Transactional
    public List<CommentResponse> execute (Long communityId) {
        if(!communityRepository.existsById(communityId)) throw CommunityNotFoundException.EXCEPTION;

        List<CommentResponse> comments = commentRepository.findAllByCommunityId(communityId)
                .stream()
                .map(CommentResponse::new)
                .toList();

        return comments;
    }
}
