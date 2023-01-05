package com.geekbrains.web_market.core.repositories;

import com.geekbrains.web_market.core.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductsRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
}
