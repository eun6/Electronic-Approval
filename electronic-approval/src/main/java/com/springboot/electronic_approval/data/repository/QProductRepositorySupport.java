package com.springboot.electronic_approval.data.repository;


import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;

import com.springboot.electronic_approval.data.entity.Product;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import static com.springboot.electronic_approval.data.entity.QProduct.product;

@Repository
public class QProductRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    public QProductRepositorySupport(JPAQueryFactory jpaQueryFactory) {
        super(Product.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<Product> findByName(String name) {
        return jpaQueryFactory.selectFrom(product)
            .where(product.price.eq(500))
            .fetch();
    }

}