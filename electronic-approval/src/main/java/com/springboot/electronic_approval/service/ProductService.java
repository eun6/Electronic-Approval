package com.springboot.electronic_approval.service;


import com.springboot.electronic_approval.data.dto.ProductDto;
import com.springboot.electronic_approval.data.dto.ProductResponseDto;

public interface ProductService {

    ProductResponseDto getProduct(Long number);

    ProductResponseDto saveProduct(ProductDto productDto);

    ProductResponseDto changeProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;

}