package com.ost.matie.service.point;

import com.ost.matie.domain.point.Point;
import com.ost.matie.dto.point.AddPointRequest;
import com.ost.matie.exception.UserNotFoundException;
import com.ost.matie.repository.point.PointRepository;
import com.ost.matie.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddPointService {
    private final PointRepository pointRepository;
    private final UserRepository userRepository;

    @Transactional
    public void execute(AddPointRequest request) {
        if(!userRepository.existsById(request.getUser().getId())) throw UserNotFoundException.EXCEPTION;
        if(request.getVariation() == null) request.setVariation(0L);
        Point point = pointRepository.findFirstByUserIdOrderByCreatedDateDesc(request.getUser().getId());
        long balance = (point != null) ? point.getBalance() + request.getVariation() : 0;
        pointRepository.save(request.toEntity(balance));
    }
}
