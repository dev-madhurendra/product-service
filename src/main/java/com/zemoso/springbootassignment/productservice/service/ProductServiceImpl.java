package com.zemoso.springbootassignment.productservice.service;

import com.zemoso.springbootassignment.productservice.dto.ProductDto;
import com.zemoso.springbootassignment.productservice.dto.ProductRequestDto;
import com.zemoso.springbootassignment.productservice.model.Product;
import com.zemoso.springbootassignment.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*
    This annotation used to indicate that the class is service component
    and it handles business logic and perform operations
*/
@Service
/*
    it generates a constructor with required (final or non-null) fields as arguments.
*/
@RequiredArgsConstructor
/*
    Simple Logging Facade for Java
    you can directly use the generated logger field to log messages
    without the need for explicit logger instantiation.
*/
@Slf4j

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> bookList = productRepository.findAll();
        log.info(bookList.get(0).getName());
        return bookList.stream().map(this::mapToProductDto).toList();
    }

    @Override
    public void addProduct(ProductRequestDto productRequestDto) {
        Product product =
                Product.builder()
                        .name(productRequestDto.getName())
                        .seller(productRequestDto.getSeller())
                        .productImage(productRequestDto.getProductImage())
                        .description(productRequestDto.getDescription())
                        .price(productRequestDto.getPrice())
                        .build();
        productRepository.save(product);
    }

    @Override
    public List<ProductDto> getProductsFromOrder(List<Long> productsOrder) {
        return productsOrder
                .stream().
                map(id -> mapToProductDto(getProductById(id)))
                .toList();
    }

    private Product getProductById(Long id) {
        Optional<Product> product =  productRepository.findById(id);
        return product.orElse(null);
    }

    @Override
    public String deleteProduct(Long id) {
        productRepository.deleteById(id);
        return "Deleted";
    }

    @Override
    public Optional<Product> getProduct(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    private ProductDto mapToProductDto(Product product) {
        log.info(product.toString());
        return ProductDto.builder().id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .seller(product.getSeller())
                .description(product.getDescription())
                .productImage(product.getProductImage())
                .build();
    }
}
