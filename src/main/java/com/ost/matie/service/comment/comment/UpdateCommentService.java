package com.ost.matie.service.comment.comment;

import com.ost.matie.domain.comment.Comment;
import com.ost.matie.dto.comment.comment.UpdateCommentRequest;
import com.ost.matie.exception.CommentNotFoundException;
import com.ost.matie.repository.comment.comment.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateCommentService {
    private final CommentRepository commentRepository;

    @Transactional
    public void execute(Long id, UpdateCommentRequest request) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> CommentNotFoundException.EXCEPTION);

        comment.update(request.getDescription());
    }
}
