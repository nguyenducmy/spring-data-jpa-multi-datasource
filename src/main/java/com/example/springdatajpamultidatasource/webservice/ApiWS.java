package com.example.springdatajpamultidatasource.webservice;

import com.example.springdatajpamultidatasource.entity.source1.Customer;
import com.example.springdatajpamultidatasource.entity.source2.Product;
import com.example.springdatajpamultidatasource.repository.source1.CustomerRepository;
import com.example.springdatajpamultidatasource.repository.source2.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiWS {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;



    @RequestMapping("/get-source-1")
    public List<Customer> getSource1(){
        return customerRepository.findAll();
    }

    @RequestMapping("/get-source-2")
    public List<Product> getSource2(){
        return productRepository.findAll();
    }
}
