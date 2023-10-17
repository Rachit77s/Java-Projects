package com.example.productservice.controllers;

import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.models.Product;
import com.example.productservice.services.IProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private IProductService productService;

    public ProductController(@Qualifier("fakeStoreProductService") IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public void getAllProducts() {

    }

    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("{id}")
    public void deleteProductById() {

    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @PutMapping("{id}")
    public void updateProductById() {

    }
}
