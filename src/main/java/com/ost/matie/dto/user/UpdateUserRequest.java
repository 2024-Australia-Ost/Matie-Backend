package com.ost.matie.dto.user;

import com.ost.matie.domain.image.Image;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateUserRequest {
    @NotBlank(message = "비밀번호 칸이 비어있습니다.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "8~20자 이내로 영문과 숫자, 특수기호가 들어가야 합니다.")
    private String pw;
}
