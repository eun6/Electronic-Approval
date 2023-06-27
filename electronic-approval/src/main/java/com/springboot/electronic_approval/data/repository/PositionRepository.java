package com.springboot.electronic_approval.data.repository;

import com.springboot.electronic_approval.data.entity.Position;
import com.springboot.electronic_approval.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Integer> {
}
