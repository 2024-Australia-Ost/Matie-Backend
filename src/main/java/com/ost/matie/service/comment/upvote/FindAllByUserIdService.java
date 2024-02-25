package com.ost.matie.service.comment.upvote;

import com.ost.matie.dto.comment.upvote.UpvoteResponse;
import com.ost.matie.exception.UserNotFoundException;
import com.ost.matie.repository.comment.upvote.UpvoteRepository;
import com.ost.matie.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FindAllByUserIdService {
    private final UpvoteRepository upvoteRepository;
    private final UserRepository userRepository;

    @Transactional
    public List<UpvoteResponse> execute(Long userId) {
        if(!userRepository.existsById(userId)) throw UserNotFoundException.EXCEPTION;

        List<UpvoteResponse> upvotes = upvoteRepository.findAllByUserId(userId)
                .stream()
                .map(UpvoteResponse::new)
                .toList();

        return upvotes;
    }
}
