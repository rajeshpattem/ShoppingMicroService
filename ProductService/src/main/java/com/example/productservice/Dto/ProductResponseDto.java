package com.example.productservice.Dto;

import com.example.productservice.Entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto extends ProductDto {
    private String id;

    public ProductResponseDto(Product product){
        this.id = product.getId();
        this.setDescription(product.getDescription());
        this.setName(product.getName());
        this.setPrice(product.getPrice());
    }
}
