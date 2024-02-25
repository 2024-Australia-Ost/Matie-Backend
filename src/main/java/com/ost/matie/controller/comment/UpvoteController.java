package com.ost.matie.controller.comment;

import com.ost.matie.dto.comment.upvote.AddUpvoteRequest;
import com.ost.matie.dto.comment.upvote.UpvoteResponse;
import com.ost.matie.service.comment.upvote.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/upvote")
public class UpvoteController {
    private final AddUpvoteService addUpvoteService;
    private final CountAllByCommentIdService countAllByCommentIdService;
    private final FindAllByUserIdService findAllByUserIdService;
    private final FindByUserIdAndCommentIdService findByUserIdAndCommentIdService;
    private final DeleteUpvoteService deleteUpvoteService;

    @PostMapping
    public void addUpvote(@Valid @RequestBody AddUpvoteRequest request) {
        addUpvoteService.execute(request);
    }

    @GetMapping("/count/{commentId}")
    public Long countAllByCommentId(@PathVariable Long commentId) {
        return countAllByCommentIdService.execute(commentId);
    }

    @GetMapping("/{userId}")
    public List<UpvoteResponse> findAllByUserId(@PathVariable Long userId) {
        return findAllByUserIdService.execute(userId);
    }

    @GetMapping("/{userId}/{commentId}")
    public UpvoteResponse findAllByUserIdAndCommentId(@PathVariable Long userId, @PathVariable Long commentId) {
        return findByUserIdAndCommentIdService.execute(userId, commentId);
    }

    @DeleteMapping("/{userId}/{commentId}")
    public void deleteUpvote(@PathVariable Long userId, @PathVariable Long commentId) {
        deleteUpvoteService.execute(userId, commentId);
    }
}
