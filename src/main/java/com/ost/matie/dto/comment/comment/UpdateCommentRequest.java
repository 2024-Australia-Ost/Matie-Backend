package com.ost.matie.dto.comment.comment;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateCommentRequest {
    @NotEmpty(message = "설명 칸이 비어있습니다.")
    private String description;
}
