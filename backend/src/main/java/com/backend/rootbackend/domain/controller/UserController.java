package com.backend.rootbackend.domain.controller;

import com.backend.rootbackend.domain.dto.request.UserCreateRequestDto;
import com.backend.rootbackend.domain.dto.request.UserUpdateRequestDto;
import com.backend.rootbackend.domain.dto.response.UserResponseDto;
import com.backend.rootbackend.domain.entity.User;
import com.backend.rootbackend.domain.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Tag(name = "User Controller", description = "User Controller REST API")
public class UserController {

    @Autowired
    private final UserService userService;

    @GetMapping
    public List<User> getAllUser() {

        return userService.getAllUser();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserCreateRequestDto dto) {
        UserResponseDto responseDto = userService.createUser(dto);

        return ResponseEntity.created(
                        WebMvcLinkBuilder
                                .linkTo(UserController.class)
                                .slash(responseDto.getUserIdx())
                                .toUri()
                )
                .body(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable UUID id) {
        UserResponseDto responseDto = userService.getUserbyId(id);

        return ResponseEntity.ok()
                .body(responseDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Optional<User>> UpdateUser(@PathVariable UUID id,@RequestBody UserUpdateRequestDto dto) {
        Optional<User> responseDto = userService.UpdateUser(id,dto);

        return ResponseEntity.ok()
                .body(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);

        return ResponseEntity.ok()
                .body("유저 정보가 삭제되었습니다.");
    }
}
