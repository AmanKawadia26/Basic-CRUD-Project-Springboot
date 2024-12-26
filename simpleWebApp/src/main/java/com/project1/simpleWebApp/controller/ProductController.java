package com.project1.simpleWebApp.controller;

import com.project1.simpleWebApp.model.Product;
import com.project1.simpleWebApp.requestDTO.AddProductRequestDTO;
import com.project1.simpleWebApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final
    ProductService productService;

    public ProductController(ProductService service) {
        this.productService = service;
    }

    @GetMapping("/products")
    public List<Product> getProducts(@RequestParam(value = "prodId", required = false) Integer prodId) {
        if (prodId != null) {
            return List.of(productService.getProductById(prodId));
        } else {
            return productService.getProducts();
        }
    }

    @PostMapping("/products")
    public String addProduct(@RequestBody AddProductRequestDTO prod) {
        Product product = new Product(prod.getProdName(), prod.getPrice());
        return productService.addProduct(product);
    }

    @PutMapping("/products")
    public String updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }
    
    @DeleteMapping("/products")
    public String deleteProduct(@RequestParam int prodId) {
        return productService.deleteProduct(prodId);
    }

}
