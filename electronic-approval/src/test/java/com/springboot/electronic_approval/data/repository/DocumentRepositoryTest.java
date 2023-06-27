package com.springboot.electronic_approval.data.repository;

import com.springboot.electronic_approval.data.entity.Document;
import com.springboot.electronic_approval.data.entity.Position;
import com.springboot.electronic_approval.data.entity.Team;
import com.springboot.electronic_approval.data.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DocumentRepositoryTest {
    @Autowired
    DocumentRepository documentRepository;

    @Test
    public void documentTest() {
        Team team= new Team();
        team.setId(3);
        team.setName("인사부");

        Position position = new Position();
        position.setId(2);
        position.setName("주임");

        User user = new User();
        user.setId(1);
        user.setName("김남길");
        user.setEmail("test@naver.com");
        user.setPw("1234");
        user.setTeam(team);
        user.setPosition(position);

//        User user2 = new User();
//        user.setId(1);
//        user.setName("강강술래");
//        user.setEmail("test@naver.com");
//        user.setPw("1234");
//        user.setTeam(team);
//        user.setPosition(position);

        Document document = new Document();
        document.setName("Test");
        document.setContent("김포공항 가는 버스 안.");
        document.setDrafter(user);
        document.setExecutor(user);
        document.setDeadline("2023-01-01");

        documentRepository.save(document);

        System.out.println("document : " + documentRepository.findById(1));
    }

}