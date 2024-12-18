package com.projects.productservice.services;

import com.projects.productservice.exceptions.ProductNotFoundException;
import com.projects.productservice.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;
public interface ProductService {
    public Product getProductById(long productId) throws ProductNotFoundException;
    public Page<Product> getAllProducts(int PageSize, int pageNumber);
    Product createProduct(String title, String description, double price, String image, String categoryName);
    Product updateProductPrice(long productId, double price) throws ProductNotFoundException;
    Product updateProductImage(long productId, String image)throws ProductNotFoundException;
    void deleteProduct(long productId)throws ProductNotFoundException;
}
