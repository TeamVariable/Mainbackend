package com.backend.rootbackend.domain.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequestDto {

    private String nickname;
    private String profileImageUrl;
    private String phoneNum;
    private String userPassword;
}
