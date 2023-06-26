package com.springboot.electronic_approval.data.repository;

import com.springboot.electronic_approval.data.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Long> {
}
