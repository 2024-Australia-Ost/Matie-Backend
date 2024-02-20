package com.ost.matie.service.email;

import com.ost.matie.config.RedisUtil;
import com.ost.matie.dto.email.AddEmailRequest;
import com.ost.matie.exception.EmailCodeExpiredException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@RequiredArgsConstructor
@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    private final RedisUtil redisUtil;
    private String authKey;

    public void sendMessage(AddEmailRequest request) {
        authKey = createCode();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("peace10200khs@gmail.com");
        message.setTo(request.getEmailAddress());
        message.setSubject("[Matie] 사용자 인증 이메일 코드");
        message.setText(authKey);
        javaMailSender.send(message);

        redisUtil.setDataExpire(request.getEmailAddress(), authKey, 60 * 3L);
    }

    public void getCode(String email, String code) {
        String codeFoundByEmail = redisUtil.getData(email);
        if(codeFoundByEmail == null || !codeFoundByEmail.equals(code)) throw EmailCodeExpiredException.EXCEPTION;
    }

    private String createCode() {
        return String.valueOf(new Random().nextInt(888888) + 111111);
    }
}
