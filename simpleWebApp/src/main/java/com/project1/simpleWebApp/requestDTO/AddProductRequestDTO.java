package com.project1.simpleWebApp.requestDTO;

public class AddProductRequestDTO {

    private String prodName;
    private int price;

    public String getProdName() {
        return prodName;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "AddProductRequestDTO{" +
                "prodName='" + prodName + '\'' +
                ", price=" + price +
                '}';
    }
}
