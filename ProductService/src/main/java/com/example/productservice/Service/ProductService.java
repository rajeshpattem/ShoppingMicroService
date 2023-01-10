package com.example.productservice.Service;

import com.example.productservice.Dto.ProductDto;
import com.example.productservice.Dto.ProductResponseDto;
import com.example.productservice.Entity.Product;
import com.example.productservice.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public boolean createProduct(ProductDto productDto) {
        Product product = new Product(productDto);
        try {
            productRepository.save(product);
            log.info("Product {} is Saved Successfully!", product.getId());
            return true;
        } catch (Exception e) {
            log.error("Product is not Saved");
            return false;
        }

    }

    public List<ProductResponseDto> fetchAllProducts() {
        return productRepository.findAll().stream()
                .map(ProductResponseDto::new)
                .collect(Collectors.toList());
    }
}
