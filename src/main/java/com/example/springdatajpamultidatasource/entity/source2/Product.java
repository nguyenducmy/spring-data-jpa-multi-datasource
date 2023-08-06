package com.example.springdatajpamultidatasource.entity.source2;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product", schema = "jpaMultiDatasource2")
@Data @AllArgsConstructor @NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String productName;
    private String productBrand;
    private String productModel;
}
