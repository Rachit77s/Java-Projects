package com.example.productservice.services;

import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.models.Product;

public interface IProductService {
    public GenericProductDto createProduct(GenericProductDto product);
    public GenericProductDto getProductById(Long id);
}
