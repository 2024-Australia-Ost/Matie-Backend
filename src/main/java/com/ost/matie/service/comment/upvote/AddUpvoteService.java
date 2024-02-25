package com.ost.matie.service.comment.upvote;

import com.ost.matie.dto.comment.upvote.AddUpvoteRequest;
import com.ost.matie.exception.CommentNotFoundException;
import com.ost.matie.exception.UpvoteDuplicateException;
import com.ost.matie.exception.UserNotFoundException;
import com.ost.matie.repository.comment.comment.CommentRepository;
import com.ost.matie.repository.comment.upvote.UpvoteRepository;
import com.ost.matie.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddUpvoteService {
    private final UpvoteRepository upvoteRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public void execute(AddUpvoteRequest request) {
        if(upvoteRepository.existsByUserIdAndCommentId(request.getUser().getId(), request.getComment().getId())) throw UpvoteDuplicateException.EXCEPTION;
        if(!userRepository.existsById(request.getUser().getId())) throw UserNotFoundException.EXCEPTION;
        if(!commentRepository.existsById(request.getComment().getId())) throw CommentNotFoundException.EXCEPTION;

        upvoteRepository.save(request.toEntity());
    }
}
