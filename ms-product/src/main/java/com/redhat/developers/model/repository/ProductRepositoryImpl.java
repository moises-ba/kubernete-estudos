package com.redhat.developers.model.repository;

import com.redhat.developers.model.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private static Map<String,Product> PRODUCTS = new HashMap<>();
    static {
        String uuid = UUID.randomUUID().toString();
        PRODUCTS.put(uuid,Product.builder().id(uuid).name("Martelo").build());
        uuid = UUID.randomUUID().toString();
        PRODUCTS.put(uuid,Product.builder().id(uuid).name("Prego").build());
        uuid = UUID.randomUUID().toString();
        PRODUCTS.put(uuid,Product.builder().id(uuid).name("Parafuso").build());
    }


    @Override
    public List<Product> findAll() {
        return new ArrayList<>(PRODUCTS.values());
    }

    @Override
    public Product findById(String id){
        return PRODUCTS.get(id);
    }
}
