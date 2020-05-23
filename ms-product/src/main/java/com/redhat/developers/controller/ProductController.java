package com.redhat.developers.controller;

import com.redhat.developers.config.AdjustmentSendConditionsProperties;
import com.redhat.developers.model.domain.Product;
import com.redhat.developers.model.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RestController
@Slf4j
public class ProductController {

    @Autowired
    private ProductRepository productRepository;



    @Autowired
    private AdjustmentSendConditionsProperties adjustmentSendConditionsProperties;


    @GetMapping("/products")
    public ResponseEntity<List<Product>> products() throws Exception {

        System.out.println(adjustmentSendConditionsProperties.mapStatusConditions());

        return ResponseEntity.ok(this.productRepository.findAll());
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> productById(@PathVariable String id) throws Exception {

        Product product = this.productRepository.findById(id);
        if(product == null) {
           return  ResponseEntity.notFound().build();
        }


        return ResponseEntity.ok(product);
    }


}
