package com.example.productservice.services;

import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.exceptions.NotFoundException;
import com.example.productservice.models.Product;

import java.util.List;

public interface IProductService {
    public GenericProductDto createProduct(GenericProductDto product);
    public GenericProductDto getProductById(Long id) throws NotFoundException;

    public List<GenericProductDto> getAllProducts();
    public GenericProductDto deleteProduct(Long id);
}
