package com.ost.matie.service.comment.comment;

import com.ost.matie.exception.CommentNotFoundException;
import com.ost.matie.repository.comment.comment.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteCommentService {
    private final CommentRepository commentRepository;

    @Transactional
    public void execute(Long id) {
        if(!commentRepository.existsById(id)) throw CommentNotFoundException.EXCEPTION;
        commentRepository.deleteById(id);
    }
}
