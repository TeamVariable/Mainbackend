package com.backend.rootbackend.domain.service;

import com.backend.rootbackend.domain.dto.request.UserCreateRequestDto;
import com.backend.rootbackend.domain.dto.request.UserUpdateRequestDto;
import com.backend.rootbackend.domain.dto.response.UserResponseDto;
import com.backend.rootbackend.domain.entity.User;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    UserResponseDto createUser(UserCreateRequestDto dto);
    Optional<User> UpdateUser(UUID id, UserUpdateRequestDto dto);
    UserResponseDto getUserbyId(UUID id);
    List<User> getAllUser();
    String deleteUser(UUID id);

    default User createUserToEntity(UserCreateRequestDto dto) {
        User user = User.builder()
                .name(dto.getName())
                .nickname(dto.getNickname())
                .profileImageUrl(dto.getProfileImageUrl())
                .phoneNum(dto.getPhoneNum())
                .userEmail(dto.getUserEmail())
                .userPassword(dto.getUserPassword())
                .build();

        return user;
    }

    default UserResponseDto userEntityToDto(User user) {
        UserResponseDto responseDto = UserResponseDto.builder()
                .userIdx(user.getUserIdx())
                .name(user.getName())
                .nickname(user.getNickname())
                .profileImageUrl(user.getProfileImageUrl())
                .phoneNum(user.getPhoneNum())
                .userEmail(user.getUserEmail())
                .userPassword(user.getUserPassword())
                .build();

        return responseDto;
    }
}
