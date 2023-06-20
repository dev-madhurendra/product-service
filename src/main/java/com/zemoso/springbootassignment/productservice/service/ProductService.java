package com.zemoso.springbootassignment.productservice.service;

import com.zemoso.springbootassignment.productservice.dto.ProductDto;
import com.zemoso.springbootassignment.productservice.dto.ProductRequestDto;
import com.zemoso.springbootassignment.productservice.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    // this function return list of all the products available in database
    List<ProductDto> getAllProducts();

    // this method is used to add the product in the database
    void addProduct(ProductRequestDto productRequestDto);

    // this method return all the products based on order
    // like decreasing or increasing
    List<ProductDto> getProductsFromOrder(List<Long> productsOrder);

    // this method used to delete a product by the id of that product
    String deleteProduct(Long id);

    // this method return a single product by given id
    // It is optional because it might be possible that
    // product is there or not of given id
    Optional<Product> getProduct(Long id);

    // This method update the product
    void updateProduct(Product product);
}
