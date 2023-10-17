package com.example.productservice.services;

import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements IProductService {

    private RestTemplateBuilder restTemplateBuilder;
    private String getProductByIdRequestUrl = "https://fakestoreapi.com/products/{id}";
    private String createProductrequestUrl = "https://fakestoreapi.com/products";

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public GenericProductDto getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response = restTemplate.getForEntity(getProductByIdRequestUrl, GenericProductDto.class, id);

        GenericProductDto genericProductDto = response.getBody();
        Product product = new Product();
        product.setImage(genericProductDto.getImage());
        product.setDescription(genericProductDto.getDescription());
        product.setTitle(genericProductDto.getTitle());
        // product.setCategory(genericProductDto.getCategory());
        product.setPrice(genericProductDto.getPrice());

        return genericProductDto;
    }

    public GenericProductDto createProduct(GenericProductDto productDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response = restTemplate.postForEntity(createProductrequestUrl, productDto ,GenericProductDto.class);

        return response.getBody();
    }
}
