package com.springboot.electronic_approval.data.repository.support;

import com.springboot.electronic_approval.data.entity.Product;

import java.util.List;

public interface ProductRepositoryCustom {

    List<Product> findByName(String name);

}