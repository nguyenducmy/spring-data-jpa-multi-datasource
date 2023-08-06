package com.example.springdatajpamultidatasource.repository.source1;

import com.example.springdatajpamultidatasource.entity.source1.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
