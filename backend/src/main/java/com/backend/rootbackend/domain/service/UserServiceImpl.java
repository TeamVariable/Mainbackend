package com.backend.rootbackend.domain.service;

import com.backend.rootbackend.domain.dto.request.UserCreateRequestDto;
import com.backend.rootbackend.domain.dto.request.UserUpdateRequestDto;
import com.backend.rootbackend.domain.dto.response.UserResponseDto;
import com.backend.rootbackend.domain.entity.User;
import com.backend.rootbackend.domain.repository.UserRepository;
import com.backend.rootbackend.global.error.exception.BusinessException;
import com.backend.rootbackend.global.error.exception.User.UserNotFoundException;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.backend.rootbackend.global.error.exception.ErrorCode.*;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDto createUser(UserCreateRequestDto dto) {
        System.err.println(dto.getUserPassword());
        try {
            String encodePassword = passwordEncoder.encode(dto.getUserPassword());
            dto.setUserPassword(encodePassword);
        } catch (Exception e) {
            throw new BusinessException(PASSWORD_ENCRYPTION_ERROR);
        }


        User entity = createUserToEntity(dto);
        userRepository.save(entity);

        UserResponseDto responseDto = userEntityToDto(entity);

        return responseDto;
    }

    @Override
    public Optional<User> UpdateUser(UUID id, UserUpdateRequestDto dto) {
        try {
            String encodePassword = passwordEncoder.encode(dto.getUserPassword());
            dto.setUserPassword(encodePassword);
        } catch (BusinessException e) {
            throw new BusinessException(PASSWORD_ENCRYPTION_ERROR);
        }
        Optional<User> result = userRepository.findById(id);
        if (result.isPresent()){
            User user = result.get();
            user.modifyUser(
                    dto.getNickname(),
                    dto.getUserPassword(),
                    dto.getPhoneNum(),
                    dto.getProfileImageUrl()
            );
            userRepository.save(user);
        }
        return result;
    }

    @Override
    public UserResponseDto getUserbyId(UUID id) {
        User entity = userRepository.getById(id);

        UserResponseDto responseDto = userEntityToDto(entity);

        return responseDto;
    }


    @Override
    public List<User> getAllUser() {

        return userRepository.findAll();
    }

    @Override
    public String deleteUser(UUID id) {
        try {
            userRepository.deleteById(id);
            return "유저정보가 삭제되었습니다.";

        } catch (BusinessException e) {
            throw new UserNotFoundException("유저를 찾을 수 없습니다.");
        }
    }
}
