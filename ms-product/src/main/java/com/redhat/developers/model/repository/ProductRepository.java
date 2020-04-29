package com.redhat.developers.model.repository;

import com.redhat.developers.model.domain.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(String id);
}
