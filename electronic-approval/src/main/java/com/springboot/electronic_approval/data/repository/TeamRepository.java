package com.springboot.electronic_approval.data.repository;

import com.springboot.electronic_approval.data.entity.Team;
import com.springboot.electronic_approval.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
}
