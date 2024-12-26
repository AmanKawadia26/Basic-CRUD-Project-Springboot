package com.project1.simpleWebApp.repository;

import com.project1.simpleWebApp.model.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query("SELECT p FROM Product p")
    List<Product> findAllProducts();

    @Query("SELECT p FROM Product p WHERE p.prodId = ?1")
    Optional<Product> findProductById(int prodId);

    @Modifying
    @Transactional
    @Query("INSERT INTO Product (prodName, price) VALUES (?1, ?2)")
    void customSave(String prodName, int price);

    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.prodName = ?1, p.price = ?2 WHERE p.prodId = ?3")
    void customUpdate(String prodName, int price, int prodId);

    @Query("DELETE FROM Product p WHERE p.prodId = ?1")
    void deleteProductById(int prodId);

}
