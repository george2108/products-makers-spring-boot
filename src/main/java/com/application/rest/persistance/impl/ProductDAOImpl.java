package com.application.rest.persistance.impl;

import com.application.rest.entities.Product;
import com.application.rest.persistance.IProductoDAO;
import com.application.rest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class ProductDAOImpl implements IProductoDAO {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findByPriceInRange(
            BigDecimal minPrice,
            BigDecimal maxPrice
    ) {
        return productRepository.findProductByPriceInRange(minPrice, maxPrice);
    }
}
