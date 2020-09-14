package org.fasttrackit.onlineshop.service;

import org.fasttrackit.onlineshop.domain.Product;
import org.fasttrackit.onlineshop.persistence.ProductRepository;
import org.fasttrackit.onlineshop.transfer.SaveProductRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Spring Bean (services, repositories etc)
@Service
public class ProductService {
//lombok - library
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    //IoC (Inversion of Control)
    private final ProductRepository productRepository;

    //Dependency injection
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(SaveProductRequest request) {

        LOGGER.info("Creating product {}", request);
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setImageUrl(request.getImageUrl());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());

        return productRepository.save(product);
    }
}
