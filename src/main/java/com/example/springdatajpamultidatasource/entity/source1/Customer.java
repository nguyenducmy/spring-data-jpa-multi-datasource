package com.example.springdatajpamultidatasource.entity.source1;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer", schema = "jpaMultiDatasource1")
@Data @AllArgsConstructor @NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String customerName;

    private String customerEmail;
}
