package com.springboot.electronic_approval.service.impl;

import com.springboot.electronic_approval.data.dto.UserDto.UserRequest;
import com.springboot.electronic_approval.data.dto.UserDto.UserResponse;
import com.springboot.electronic_approval.data.entity.Position;
import com.springboot.electronic_approval.data.entity.Team;
import com.springboot.electronic_approval.data.entity.User;
import com.springboot.electronic_approval.data.repository.PositionRepository;
import com.springboot.electronic_approval.data.repository.TeamRepository;
import com.springboot.electronic_approval.data.repository.UserRepository;
import com.springboot.electronic_approval.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final TeamRepository teamRepository;
    private final PositionRepository positionRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, TeamRepository teamRepository, PositionRepository positionRepository) {
        this.userRepository = userRepository;
        this.teamRepository = teamRepository;
        this.positionRepository = positionRepository;
    }

    @Override
    public UserResponse getUser(int id) {
        LOGGER.info("[get User] input id : {}", id);
        User user = userRepository.findById(id).get();
        LOGGER.info("[get User] user teamId : {}, name : {}", user.getTeam().getId(),
                user.getName());
        UserResponse userResponseDto = UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .pw(user.getPw())
                .teamId(user.getTeam().getId())
                .positionId(user.getPosition().getId())
                .build();

        return userResponseDto;
    }

    @Override
    public UserResponse saveUser(UserRequest userRequest) {
        //노예인 team과 postion 정보 가져오기
        LOGGER.info("[team] teamID : {}", userRequest.getTeamId());
        Team team = teamRepository.getById(userRequest.getTeamId());
        LOGGER.info("[postion] postionID : {}", userRequest.getPositionId());
        Position position = positionRepository.getById(userRequest.getPositionId());

        //user 객체 생성
        LOGGER.info("[save User] userInfo : {}", userRequest.toString());
        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPw(userRequest.getPw());
        user.setTeam(team);
        user.setPosition(position);
        
        //생성한 user 객체 레포지토리에 저장
        User savedUser = userRepository.save(user);
        UserResponse userResponseDto = UserResponse.builder()
                .id(savedUser.getId())
                .name(savedUser.getName())
                .email(savedUser.getEmail())
                .pw(savedUser.getPw())
                .teamId(savedUser.getTeam().getId())
                .positionId(savedUser.getPosition().getId())
                .build();
        return userResponseDto;
    }

    //어떤 항목을 수정 가능하게 할지 미정 -> 추후 코드 작성
    @Override
    public UserResponse changeUserInfo(String email, String name) throws Exception {
        return null;
    }

    //정상 삭제되는 것까지는 확인
    @Override
    public void deleteUser(int id) throws Exception {
        userRepository.deleteById(id);
    }
}
