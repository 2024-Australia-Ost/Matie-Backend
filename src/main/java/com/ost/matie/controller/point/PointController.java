package com.ost.matie.controller.point;

import com.ost.matie.dto.point.AddPointRequest;
import com.ost.matie.dto.point.PointResponse;
import com.ost.matie.service.point.AddPointService;
import com.ost.matie.service.point.FindByUserIdPointService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/point")
public class PointController {
    private final AddPointService addPointService;
    private final FindByUserIdPointService findByUserIdPointService;

    @PostMapping
    public void addPoint(@Valid @RequestBody AddPointRequest request) {
        addPointService.execute(request);
    }

    @GetMapping("/{userId}")
    public PointResponse findFirstByUserIdOrderByCreatedDateDesc(@PathVariable Long userId) {
        return findByUserIdPointService.execute(userId);
    }
}
