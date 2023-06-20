package com.zemoso.springbootassignment.controller;

import com.zemoso.springbootassignment.productservice.controller.ProductController;
import com.zemoso.springbootassignment.productservice.dto.ProductDto;
import com.zemoso.springbootassignment.productservice.dto.ProductRequestDto;
import com.zemoso.springbootassignment.productservice.model.Product;
import com.zemoso.springbootassignment.productservice.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductControllerTest {
    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllProducts() {
        // Mock data
        List<ProductDto> expectedProducts = Arrays.asList(new ProductDto(),new ProductDto());
        when(productService.getAllProducts()).thenReturn(expectedProducts);

        // Perform the GET request
        List<ProductDto> actualBooks = productController.getAllProducts();

        // Verify the result
        assertEquals(expectedProducts, actualBooks);
        verify(productService, times(1)).getAllProducts();
    }

    @Test
    void testAddProduct() {
        // Mock data
        ProductRequestDto productRequestDto = new ProductRequestDto();

        // Perform the POST request
        productController.addProduct(productRequestDto);

        // Verify that the bookService.addBook method is called once
        verify(productService, times(1)).addProduct(productRequestDto);
    }

    @Test
    void testGetProduct() {
        // Mock data
        Long productId = 1L;
        Product expectedProduct= new Product();
        when(productService.getProduct(productId)).thenReturn(Optional.of(expectedProduct));

        // Perform the GET request
        Optional<Product> actualProduct = productController.getProduct(productId);

        // Verify the result
        assertEquals(Optional.of(expectedProduct), actualProduct);
        verify(productService, times(1)).getProduct(productId);
    }

    @Test
    void testGetProductsFromOrder() {
        // Mock data
        List<Long> idList = Arrays.asList(1L, 2L);
        List<ProductDto> expectedProducts = Arrays.asList(new ProductDto(), new ProductDto());
        when(productService.getProductsFromOrder(idList)).thenReturn(expectedProducts);

        // Perform the POST request
        List<ProductDto> actualProducts = productController.getProductsFromOrder(idList);

        // Verify the result
        assertEquals(expectedProducts, actualProducts);
        verify(productService, times(1)).getProductsFromOrder(idList);
    }

    @Test
    void testUpdateProduct() {
        // Mock data
        ProductDto productDto = new ProductDto();

        // Perform the PUT request
        productController.updateProduct(productDto);

        // Verify that the bookService.updateBook method is called once
        verify(productService, times(1)).updateProduct(any());
    }
}






