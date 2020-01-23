package com.example.billingservice.entities;

public class Product {
    private Long id;

    private String name;

    private double price;

    public Product(){};
    public Product(Long id,String name,double price){
        this.id=id;this.name=name;this.price=price;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
