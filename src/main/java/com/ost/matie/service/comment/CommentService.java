package com.ost.matie.service.comment;

import com.ost.matie.domain.comment.Comment;
import com.ost.matie.dto.comment.AddCommentRequest;
import com.ost.matie.dto.comment.UpdateCommentRequest;
import com.ost.matie.exception.NotFoundException;
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
        if(!commentRepository.existsById(id)) throw new NotFoundException("댓글의 정보를 찾을 수 없습니다. (id : " + id + ")");
        commentRepository.deleteById(id);
    }

    @Transactional
    public Comment update(Long id, UpdateCommentRequest request) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("댓글의 정보를 찾을 수 없습니다. (id : " + id + ")"));

        for(Long userId : request.getUpvoteUserList())
            if(!userRepository.existsById(userId)) throw new NotFoundException("사용자 정보를 찾을 수 없습니다. (id : " + userId + ")");

        comment.update(
                request.getDescription(),
                request.getUpvotes(),
                request.getUpvoteUserList()
        );

        return comment;
    }
}
