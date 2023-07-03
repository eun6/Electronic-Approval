package com.springboot.electronic_approval.service;

import com.springboot.electronic_approval.data.dto.UserDto.UserResponse;
import com.springboot.electronic_approval.data.dto.UserDto.UserRequest;

public interface UserService {
    UserResponse getUser(int id);
    UserResponse saveUser(UserRequest userRequest);
    UserResponse changeUserInfo(String email, String name) throws Exception;
    void deleteUser(int id) throws Exception;
}
