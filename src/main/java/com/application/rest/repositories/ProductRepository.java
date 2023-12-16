package com.application.rest.repositories;

import com.application.rest.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    // hacer consultas con Query Methods
    // usar palabras clave de Spring Data JPA
    List<Product> findProductByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

    // hacer consultas con JPQL
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN ?1 AND ?2")
    List<Product> findProductByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);
}
