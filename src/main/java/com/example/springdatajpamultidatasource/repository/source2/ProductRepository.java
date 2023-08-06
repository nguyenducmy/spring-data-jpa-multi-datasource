package com.example.springdatajpamultidatasource.repository.source2;

import com.example.springdatajpamultidatasource.entity.source2.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
