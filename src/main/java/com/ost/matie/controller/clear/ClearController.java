package com.ost.matie.controller.clear;

import com.ost.matie.dto.clear.AddClearRequest;
import com.ost.matie.dto.clear.ClearResponse;
import com.ost.matie.service.clear.AddClearService;
import com.ost.matie.service.clear.FindByUserIdService;
import com.ost.matie.service.clear.FindDay7ByUserIdService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clear")
public class ClearController {
    private final AddClearService addClearService;
    private final FindDay7ByUserIdService findDay7ByUserIdService;
    private final FindByUserIdService findByUserIdService;

    @PostMapping
    public void addClear(@Valid @RequestBody AddClearRequest request) {
        addClearService.execute(request);
    }

    @GetMapping("/day/{userId}")
    public List<ClearResponse> findDay7ByUserId(@PathVariable Long userId) {
        return findDay7ByUserIdService.execute(userId);
    }

    @GetMapping("/{userId}")
    public List<ClearResponse> findByUserId(@PathVariable Long userId) {
        return findByUserIdService.execute(userId);
    }
}
