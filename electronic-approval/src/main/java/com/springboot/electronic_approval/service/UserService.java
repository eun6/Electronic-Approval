package com.springboot.electronic_approval.service;

import com.springboot.electronic_approval.data.dto.UserDto.UserResponse;
import com.springboot.electronic_approval.data.dto.UserDto.UserRequest;
import com.springboot.electronic_approval.data.dto.UserDto.UserUpdate;

public interface UserService {
    UserResponse getUser(int id);
    UserResponse saveUser(UserRequest userRequest);
    UserResponse changeUserInfo(int id, UserUpdate userUpdate) throws Exception;
    void deleteUser(int id) throws Exception;
}
