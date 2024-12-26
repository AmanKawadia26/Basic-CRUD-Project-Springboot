package com.project1.simpleWebApp.service;

import com.project1.simpleWebApp.model.Product;
import com.project1.simpleWebApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final
    ProductRepository productRepository;

    public ProductService(ProductRepository repository) {
        this.productRepository = repository;
    }

    public List<Product> getProducts() {
        return productRepository.findAllProducts();
    }

    public Product getProductById(int prodId) {
        Optional<Product> productOptional = productRepository.findProductById(prodId);
        return productOptional.orElse(new Product());
    }

    public String addProduct(Product product) {
        productRepository.customSave(product.getProdName(), product.getPrice());
        return "Product added successfully";
    }

    public String updateProduct(Product product) {
        productRepository.customUpdate(product.getProdName(), product.getPrice(), product.getProdId());
        return "Product updated successfully";
    }

    public String deleteProduct(int prodId) {
        productRepository.deleteProductById(prodId);
        return "Product " + prodId + " deleted successfully";
    }
}
