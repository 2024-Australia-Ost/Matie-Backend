package com.ost.matie.service.comment;

import com.ost.matie.domain.comment.Comment;
import com.ost.matie.dto.comment.AddCommentRequest;
import com.ost.matie.dto.comment.UpdateCommentRequest;
import com.ost.matie.exception.CommentNotFoundException;
import com.ost.matie.exception.UserNotFoundException;
import com.ost.matie.repository.comment.CommentRepository;
import com.ost.matie.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    public Comment save(AddCommentRequest request) {
        return commentRepository.save(request.toEntity());
    }

    public List<Comment> findAllByCommunityId(Long communityId) {
        return commentRepository.findAllByCommunityId(communityId);
    }

    public void delete(Long id) {
        if(!commentRepository.existsById(id)) throw CommentNotFoundException.EXCEPTION;
        commentRepository.deleteById(id);
    }

    @Transactional
    public Comment update(Long id, UpdateCommentRequest request) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> CommentNotFoundException.EXCEPTION);

        for(Long userId : request.getUpvoteUserList())
            if(!userRepository.existsById(userId)) throw UserNotFoundException.EXCEPTION;

        comment.update(
                request.getDescription(),
                request.getUpvotes(),
                request.getUpvoteUserList()
        );

        return comment;
    }
}
