package com.springboot.electronic_approval.data.repository;

import com.springboot.electronic_approval.data.entity.Position;
import com.springboot.electronic_approval.data.entity.Team;
import com.springboot.electronic_approval.data.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void userTest() {
        Team team= new Team();
        team.setId(3);
        team.setName("인사부");

        Position position = new Position();
        position.setId(2);
        position.setName("주임");

        User user = new User();
        user.setName("김남길");
        user.setEmail("test@naver.com");
        user.setPw("1234");
        user.setTeam(team);
        user.setPosition(position);

        userRepository.save(user);
        System.out.println("user : " + userRepository.findById(1));
    }
}