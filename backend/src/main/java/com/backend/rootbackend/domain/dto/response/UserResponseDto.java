package com.backend.rootbackend.domain.dto.response;


import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class UserResponseDto {

    private UUID userIdx;
    private String name;
    private String nickname;
    private String profileImageUrl;
    private String phoneNum;
    private String userEmail;
    private String userPassword;
    private LocalDate modDate;
    private LocalDate regDate;

}
