package com.springboot.electronic_approval.controller;

import com.springboot.electronic_approval.data.dto.UserDto.UserResponse;
import com.springboot.electronic_approval.data.dto.UserDto.UserRequest;
import com.springboot.electronic_approval.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get")
    public ResponseEntity<UserResponse> getUserInfo(int id) {
        UserResponse userResponseDto = userService.getUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

    @PostMapping("/post")
    public ResponseEntity<UserResponse> saveUserInfo(@RequestBody UserRequest userRequest) {
        UserResponse userResponseDto = userService.saveUser(userRequest);
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

    @PatchMapping("/patch")
    public ResponseEntity<UserResponse> changeUserInfo(@RequestBody UserRequest userRequest) throws Exception {
        UserResponse userResponseDto = userService.changeUserInfo(userRequest.getEmail(), userRequest.getName());
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUserInfo(int id) throws Exception{
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("정상 삭제");
    }
}
