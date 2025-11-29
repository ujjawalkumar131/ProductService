package com.example.ProductService.services;

import com.example.ProductService.dtos.FakeStoreProductDto;
import com.example.ProductService.models.Category;
import com.example.ProductService.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    //for api call restTemplete object is req;

    // obj banao // rest temp ka bean bhi banao
    private RestTemplate restTemplate;
    //initialize with calling constructor

    public FakeStoreProductService(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    private Product convertDtoToProduct(FakeStoreProductDto fakeStoreProductDto)
    {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImageUrl(fakeStoreProductDto.getImage());
        product.setPrice(fakeStoreProductDto.getPrice());

        Category cat = new Category();
        cat.setName(fakeStoreProductDto.getCategory());
        product.setCategory(cat);
        return product;

    }

    @Override
    public Product getProductById(Long id) {
        //need to make an api call for getting product

      FakeStoreProductDto fakeStoreProductDto =  restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id ,
                FakeStoreProductDto.class
        );

      //convert FakeStoreProductDto to Product Obj

        return convertDtoToProduct(fakeStoreProductDto);


    }

    @Override
    public List<Product> getAllProducts() {

        // we are getting all product in arraylist
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject(
                "https://fakestoreapi.com/products" ,
                FakeStoreProductDto[].class
        );

        List<Product> products = new ArrayList<>();

        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos)
        {
            products.add(convertDtoToProduct(fakeStoreProductDto));
        }

        return products;



    }
}
