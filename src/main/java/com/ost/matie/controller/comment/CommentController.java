package com.ost.matie.controller.comment;

import com.ost.matie.dto.comment.comment.AddCommentRequest;
import com.ost.matie.dto.comment.comment.CommentResponse;
import com.ost.matie.dto.comment.comment.UpdateCommentRequest;
import com.ost.matie.service.comment.comment.AddCommentService;
import com.ost.matie.service.comment.comment.DeleteCommentService;
import com.ost.matie.service.comment.comment.FindAllByCommunityIdService;
import com.ost.matie.service.comment.comment.UpdateCommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentController {
    private final AddCommentService addCommentService;
    private final FindAllByCommunityIdService findAllByCommunityIdService;
    private final UpdateCommentService updateCommentService;
    private final DeleteCommentService deleteCommentService;

    @PostMapping
    public void addComment(@Valid @RequestBody AddCommentRequest request) {
        addCommentService.execute(request);
    }

    @GetMapping("/{communityId}")
    public List<CommentResponse> findAllByCommunityId(@PathVariable Long communityId) {
        return findAllByCommunityIdService.execute(communityId);
    }

    @PutMapping("/{id}")
    public void updateComment(@PathVariable Long id, @Valid @RequestBody UpdateCommentRequest request) {
        updateCommentService.execute(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        deleteCommentService.execute(id);
    }
}
