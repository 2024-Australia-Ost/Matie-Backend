package com.ost.matie.service.comment.upvote;

import com.ost.matie.exception.CommentNotFoundException;
import com.ost.matie.exception.UpvoteNotFoundException;
import com.ost.matie.exception.UserNotFoundException;
import com.ost.matie.repository.comment.comment.CommentRepository;
import com.ost.matie.repository.comment.upvote.UpvoteRepository;
import com.ost.matie.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteUpvoteService {
    private final UpvoteRepository upvoteRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public void execute(Long userId, Long commentId) {
        if(!userRepository.existsById(userId)) throw UserNotFoundException.EXCEPTION;
        if(!commentRepository.existsById(commentId)) throw CommentNotFoundException.EXCEPTION;
        if(!upvoteRepository.existsByUserIdAndCommentId(userId, commentId)) throw UpvoteNotFoundException.EXCEPTION;

        upvoteRepository.deleteByUserIdAndCommentId(userId, commentId);
    }
}
