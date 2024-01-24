package com.ost.matie.controller.email;

import com.ost.matie.dto.email.AddEmailRequest;
import com.ost.matie.service.email.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class EmailController {
    private final EmailService emailService;

    @PostMapping("/email")
    public ResponseEntity<String> sendEmail(@RequestBody AddEmailRequest request) {
        emailService.sendMessage(request);
        return ResponseEntity.ok().body("성공적으로 보냈습니다.");
    }

    @GetMapping("/email/{email}/{code}")
    public ResponseEntity<String> getEmail(@PathVariable String email, @PathVariable String code) {
        emailService.getCode(email, code);
        return ResponseEntity.ok().body(email + "에 해당하는 " + code + "찾았습니다");
    }
}
