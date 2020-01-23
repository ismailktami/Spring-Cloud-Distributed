package com.example.billingservice.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
public class Bill {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date billingDate;

    private Long customerId;


    @Transient
    private Customer customer;
    @OneToMany(mappedBy = "bill")
    private Collection<ProductItem> productItems;

    public Bill(Date d,Long i,Collection<ProductItem> p){
        this.billingDate=d;this.customerId=i;
        this.productItems=p;
    }
    public Bill(){};

    public Long getId() {
        return id;
    }

    public Collection<ProductItem> getProductItems() {
        return productItems;
    }

    public Date getBillingDate() {
        return billingDate;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBillingDate(Date billingDate) {
        this.billingDate = billingDate;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setProductItems(Collection<ProductItem> productItems) {
        this.productItems = productItems;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
