package com.springboot.electronic_approval.data.repository;

import com.springboot.electronic_approval.data.entity.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeamRepositoryTest {
    @Autowired
    TeamRepository teamRepository;

    @Test
    public void newTeamTest() {
        Team team = new Team();
        team.setName("인적자원관리부");


        teamRepository.save(team);

        System.out.println("team : " + teamRepository.findById(3));
    }

}