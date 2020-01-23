package com.example.billingservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class ProductItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;

    @Transient
    //n'est pas persistent
    private Product product;
    private double price;

    private double quantite;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Bill bill;


    public ProductItem(){}
    public ProductItem(Long p,double pr,double q,Bill b){
        this.productId=p;this.price=pr;this.quantite=q;this.bill=b;
    }

    public Long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public Bill getBill() {
        return bill;
    }

    public Long getProductId() {
        return productId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public double getQuantite() {
        return quantite;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
