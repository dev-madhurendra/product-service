package com.zemoso.springbootassignment.productservice.repository;

import com.zemoso.springbootassignment.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
    Provide abstraction layer for interacting data
    Works as an  intermediary between the application's business logic and the underlying
    data
    responsible for data access and encapsulate interactions with a database
*/
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    // boom nothing is here
}
