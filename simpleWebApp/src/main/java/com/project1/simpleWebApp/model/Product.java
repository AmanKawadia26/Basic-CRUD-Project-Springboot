package com.project1.simpleWebApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

//@Data
//@AllArgsConstructor
//@Component
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id")
    private Integer prodId;

    @Column(name = "prod_name")
    private String prodName;

    @Column(name = "price")
    private int price;

    public Product() {
    }

    public Product(String prodName, int price) {
        this.prodName = prodName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "prodId=" + prodId +
                ", prodName='" + prodName + '\'' +
                ", price=" + price +
                '}';
    }

    public int getProdId() {
        return prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public int getPrice() {
        return price;
    }
}
