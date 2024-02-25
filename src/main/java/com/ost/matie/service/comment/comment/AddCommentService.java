package com.ost.matie.service.comment.comment;

import com.ost.matie.dto.comment.comment.AddCommentRequest;
import com.ost.matie.exception.CommunityNotFoundException;
import com.ost.matie.exception.UserNotFoundException;
import com.ost.matie.repository.comment.comment.CommentRepository;
import com.ost.matie.repository.community.CommunityRepository;
import com.ost.matie.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddCommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final CommunityRepository communityRepository;

    @Transactional
    public void execute(AddCommentRequest request) {
        if(!userRepository.existsById(request.getUser().getId())) throw UserNotFoundException.EXCEPTION;
        if(!communityRepository.existsById(request.getCommunity().getId())) throw CommunityNotFoundException.EXCEPTION;

        commentRepository.save(request.toEntity());
    }
}
