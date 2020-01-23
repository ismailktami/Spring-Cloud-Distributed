package com.example.billingservice.entities;

import org.springframework.data.rest.core.config.Projection;

import java.util.Collection;
import java.util.Date;

@Projection(name = "fullBill",types = Bill.class)
public interface BillFullProjection {
    public Long getId();
    public Long getCustomerId();
    public Date getBillingDate();
    public Collection<ProductItem> getProductItems();


}
