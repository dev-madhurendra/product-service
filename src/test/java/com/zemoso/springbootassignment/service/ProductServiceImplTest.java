package com.zemoso.springbootassignment.service;

import com.zemoso.springbootassignment.productservice.controller.ProductController;
import com.zemoso.springbootassignment.productservice.dto.ProductDto;
import com.zemoso.springbootassignment.productservice.dto.ProductRequestDto;
import com.zemoso.springbootassignment.productservice.model.Product;
import com.zemoso.springbootassignment.productservice.repository.ProductRepository;
import com.zemoso.springbootassignment.productservice.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductServiceImplTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllProducts() {
        // Mock data
        List<Product> productList = new ArrayList<>();
        productList.add(new Product());
        when(productRepository.findAll()).thenReturn(productList);

        // Perform the method under test
        List<ProductDto> result = productService.getAllProducts();

        // Verify the result
        assertEquals(productList.size(), result.size());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testAddProduct() {
        // Mock data
        ProductRequestDto productRequestDto = new ProductRequestDto();

        // Perform the method under test
        productService.addProduct(productRequestDto);

        // Verify that the ProductRepository.save method is called once
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    void testGetProductsFromOrder() {
        List<Long> productsOrder = new ArrayList<>();
        productsOrder.add(1L);
        List<ProductDto> productDtoList = new ArrayList<>();
        productDtoList.add(new ProductDto());

        Product product = Product.builder()
                .id(1L)
                .name("Sample Product")
                .seller("Sample Author")
                .price(BigDecimal.valueOf(19.99))
                .description("Sample Description")
                .productImage("Sample Cover Source")
                .build();

        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        // Perform the method under test
        List<ProductDto> result = productService.getProductsFromOrder(productsOrder);

        // Verify the result
        assertEquals(productDtoList.size(), result.size());
        verify(productRepository, times(1)).findById(1L);
    }

    @Test
    void testDeleteProduct() {
        // Mock data
        Long id = 1L;

        // Perform the method under test
        String result = productService.deleteProduct(id);

        // Verify the result
        assertEquals("Deleted", result);
        verify(productRepository, times(1)).deleteById(id);
    }

    @Test
    void testGetProduct() {
        // Mock data
        Long id = 1L;
        Optional<Product> expectedProduct = Optional.of(new Product());
        when(productRepository.findById(id)).thenReturn(expectedProduct);

        // Perform the method under test
        Optional<Product> result = productService.getProduct(id);

        // Verify the result
        assertEquals(expectedProduct, result);
        verify(productRepository, times(1)).findById(id);
    }

    @Test
    void testUpdateProduct() {
        // Mock data
        Product product = new Product();

        // Perform the method under test
        productService.updateProduct(product);

        // Verify that the ProductRepository.save method is called once
        verify(productRepository, times(1)).save(product);
    }
}