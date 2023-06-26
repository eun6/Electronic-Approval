package com.springboot.electronic_approval.data.repository;

import com.springboot.electronic_approval.data.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {
}
