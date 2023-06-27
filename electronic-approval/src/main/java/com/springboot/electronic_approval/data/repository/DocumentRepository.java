package com.springboot.electronic_approval.data.repository;

import com.springboot.electronic_approval.data.entity.Document;
import com.springboot.electronic_approval.data.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Integer> {
}
