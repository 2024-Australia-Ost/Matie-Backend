package com.ost.matie.service.comment.upvote;

import com.ost.matie.exception.CommentNotFoundException;
import com.ost.matie.repository.comment.comment.CommentRepository;
import com.ost.matie.repository.comment.upvote.UpvoteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CountAllByCommentIdService {
    private final UpvoteRepository upvoteRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public Long execute(Long commentId) {
        if(!commentRepository.existsById(commentId)) throw CommentNotFoundException.EXCEPTION;
        return upvoteRepository.countAllByCommentId(commentId);
    }
}
