package com.springboot.electronic_approval.data.repository;

import com.springboot.electronic_approval.data.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
