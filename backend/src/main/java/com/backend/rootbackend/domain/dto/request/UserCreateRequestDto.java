package com.backend.rootbackend.domain.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class UserCreateRequestDto {

    private String name;
    private String nickname;
    private String profileImageUrl;
    private String phoneNum;
    private String userEmail;
    private String userPassword;

}
