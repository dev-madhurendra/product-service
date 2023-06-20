package com.zemoso.springbootassignment.productservice.controller;

import com.zemoso.springbootassignment.productservice.dto.ProductDto;
import com.zemoso.springbootassignment.productservice.dto.ProductRequestDto;
import com.zemoso.springbootassignment.productservice.model.Product;
import com.zemoso.springbootassignment.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public List<ProductDto> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody ProductRequestDto productRequestDto){
        productService.addProduct(productRequestDto);
    }
    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable("id") Long id){
        return productService.getProduct(id);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        return productService.deleteProduct(id);
    }

    @PostMapping("/getProductsFromOrder")
    public List<ProductDto> getProductsFromOrder(@RequestBody List<Long> idList){
        return productService.getProductsFromOrder(idList);
    }
    @PutMapping
    public void updateProduct(@RequestBody ProductDto productDto){
        Product product= Product.builder()
                .id(productDto.getId())
                .price(productDto.getPrice())
                .name(productDto.getName())
                .description(productDto.getDescription())
                .productImage(productDto.getProductImage())
                .seller(productDto.getSeller())
                .build();
        productService.updateProduct(product);
    }

}
