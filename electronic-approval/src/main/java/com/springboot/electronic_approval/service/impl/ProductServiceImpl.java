/*package com.springboot.electronic_approval.service.impl;

import com.springboot.electronic_approval.data.dto.ProductDto;
import com.springboot.electronic_approval.data.dto.ProductResponseDto;
import com.springboot.electronic_approval.data.entity.User;
import com.springboot.electronic_approval.data.repository.ProductRepository;
import com.springboot.electronic_approval.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponseDto getProduct(Long number) {
        LOGGER.info("[getProduct] input number : {}", number);
        User user = productRepository.findById(number).get();

        LOGGER.info("[getProduct] product number : {}, name : {}", user.getNumber(),
                user.getName());
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNumber(user.getNumber());
        productResponseDto.setName(user.getName());
        productResponseDto.setPrice(user.getPrice());
        productResponseDto.setStock(user.getStock());

        return productResponseDto;
    }

    @Override
    public ProductResponseDto saveProduct(ProductDto productDto) {
        LOGGER.info("[saveProduct] productDTO : {}", productDto.toString());
        User user = new User();
        user.setName(productDto.getName());
        user.setPrice(productDto.getPrice());
        user.setStock(productDto.getStock());

        User savedUser = productRepository.save(user);
        LOGGER.info("[saveProduct] savedProduct : {}", savedUser);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNumber(savedUser.getNumber());
        productResponseDto.setName(savedUser.getName());
        productResponseDto.setPrice(savedUser.getPrice());
        productResponseDto.setStock(savedUser.getStock());

        return productResponseDto;
    }

    @Override
    public ProductResponseDto changeProductName(Long number, String name) {
        User foundUser = productRepository.findById(number).get();
        foundUser.setName(name);
        User changedUser = productRepository.save(foundUser);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNumber(changedUser.getNumber());
        productResponseDto.setName(changedUser.getName());
        productResponseDto.setPrice(changedUser.getPrice());
        productResponseDto.setStock(changedUser.getStock());

        return productResponseDto;
    }

    @Override
    public void deleteProduct(Long number) {
        productRepository.deleteById(number);
    }
}
*/